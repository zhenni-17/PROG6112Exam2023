package za.co.myemeris.st10468354.question2;

public class EstateAgent implements IEstateAgent {

    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        try {
            double price = Double.parseDouble(propertyPrice);
            double percentage = Double.parseDouble(agentCommission);
            return price * (percentage / 100.0);
        } catch (NumberFormatException e) {
            return 0.0; // Return 0 if text is invalid
        }
    }

    @Override
    public boolean ValidateData(Data dataToValidate) {
        if (dataToValidate.getLocation() == null || dataToValidate.getLocation().trim().isEmpty()) return false;
        if (dataToValidate.getName() == null || dataToValidate.getName().trim().isEmpty()) return false;
        
        try {
            double price = Double.parseDouble(dataToValidate.getPropertyPrice());
            if (price <= 0) return false;

            double percentage = Double.parseDouble(dataToValidate.getCommissionPercentage());
            if (percentage <= 0) return false;
            
        } catch (NumberFormatException e) {
            return false; 
        }

        return true;
    }
}
