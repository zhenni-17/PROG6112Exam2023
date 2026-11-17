package za.co.myemeris.st10468354.question2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EstateAgentGUI extends JFrame {

    private final EstateAgent controller = new EstateAgent();

    private JComboBox<String> cmbLocation;
    private JTextField txtName;
    private JTextField txtPropertyPrice;
    private JTextField txtCommission;
    private JTextArea txtReport;

    public EstateAgentGUI() {
        setTitle("Estate Agent Report");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initMenu();
        initForm();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process Report");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem saveItem = new JMenuItem("Save Report");
        
        processItem.addActionListener(e -> processReport());
        clearItem.addActionListener(e -> clearForm());
        saveItem.addActionListener(e -> saveToFile());
        
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        toolsMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void initForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Row 0: Location
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panel.add(new JLabel("AGENT LOCATION:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        cmbLocation = new JComboBox<>(new String[]{"Cape Town", "Durban", "Pretoria"});
        panel.add(cmbLocation, gbc);

        // Row 1: Name
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panel.add(new JLabel("ESTATE AGENT NAME:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtName = new JTextField();
        panel.add(txtName, gbc);

        // Row 2: Property Price
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panel.add(new JLabel("PROPERTY PRICE:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtPropertyPrice = new JTextField();
        panel.add(txtPropertyPrice, gbc);

        // Row 3: Commission Percentage
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        panel.add(new JLabel("COMMISSION PERCENTAGE:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtCommission = new JTextField();
        panel.add(txtCommission, gbc);

        // Row 4: Report Label
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0;
        panel.add(new JLabel("ESTATE AGENT REPORT:"), gbc);

        // Row 5: Text Area
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.weightx = 1; gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        txtReport = new JTextArea();
        txtReport.setEditable(false);
        panel.add(new JScrollPane(txtReport), gbc);

        add(panel);
    }

    private void processReport() {
        String location = (String) cmbLocation.getSelectedItem();
        String name = txtName.getText().trim();
        String priceStr = txtPropertyPrice.getText().trim();
        String commStr = txtCommission.getText().trim();

        Data dataToValidate = new Data(location, name, priceStr, commStr);

        // 1. Validate
        if (!controller.ValidateData(dataToValidate)) {
            JOptionPane.showMessageDialog(this, "Invalid data. Ensure name is not empty, and numbers are > 0.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Calculate and Display
        double commission = controller.CalculateCommission(priceStr, commStr);
        double price = Double.parseDouble(priceStr);
        double commPercentage = Double.parseDouble(commStr);

        String report = String.format(
            "AGENT LOCATION: %s%n" +
            "AGENT NAME: %s%n" +
            "PROPERTY PRICE: R %.1f%n" +
            "COMMISSION PERCENTAGE: %.1f%%%n" +
            "CALCULATED COMMISSION: R %.1f%n",
            location, name, price, commPercentage, commission
        );

        txtReport.setText(report);
    }

    private void saveToFile() {
        if (txtReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please process a report first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            writer.write("ESTATE AGENT REPORT\n");
            writer.write("**********************************\n\n");
            writer.write(txtReport.getText());
            writer.write("\n**********************************\n");
            JOptionPane.showMessageDialog(this, "Report saved successfully to report.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        cmbLocation.setSelectedIndex(0);
        txtName.setText("");
        txtPropertyPrice.setText("");
        txtCommission.setText("");
        txtReport.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstateAgentGUI().setVisible(true));
    }
}
