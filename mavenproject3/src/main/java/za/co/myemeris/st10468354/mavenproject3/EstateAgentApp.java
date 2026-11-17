package za.co.myemeris.st10468354.mavenproject3;

public class EstateAgentApp {
    public static void main(String[] args) {
        // Hardcoded agents and data as required by the exam paper
        String[] agents = {"Joe Bloggs", "Jane Doe"};
        String[] months = {"JAN", "FEB", "MAR"};
        
        // 2D Array: Rows are agents, Columns are months
        double[][] salesData = {
            {800000.0, 1500000.0, 2000000.0}, // Joe Bloggs
            {700000.0, 1200000.0, 1600000.0}  // Jane Doe
        };

        EstateAgent ea = new EstateAgent();
        double[] totalSales = new double[agents.length];

        // Print Header
        System.out.println("ESTATE AGENTS SALES REPORT");
        System.out.printf("%-15s", "");
        for (String month : months) {
            System.out.printf("%-15s", month);
        }
        System.out.println();

        // Print Sales Data & Calculate Totals
        for (int i = 0; i < agents.length; i++) {
            System.out.printf("%-15s", agents[i]);
            for (int j = 0; j < salesData[i].length; j++) {
                System.out.printf("R %-13.1f", salesData[i][j]);
            }
            System.out.println();
            
            // Calculate total for this agent using the class method
            totalSales[i] = ea.EstateAgentSales(salesData[i]);
        }
        
        System.out.println(); // Blank line

        // Print Totals and Commissions
        for (int i = 0; i < agents.length; i++) {
            double commission = ea.EstateAgentCommission(totalSales[i]);
            System.out.printf("Total property sales for %s = R %,.0f%n", agents[i], totalSales[i]);
            System.out.printf("Sales Commission for %s = R %,.0f%n", agents[i], commission);
        }
        
        // Determine and print top agent
                int topIndex = ea.TopEstateAgent(totalSales);
                System.out.println("Top performing estate agent: " + agents[topIndex]);
    }
}