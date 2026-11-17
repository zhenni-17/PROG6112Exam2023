package za.co.myemeris.st10468354.mavenproject3;

public class EstateAgent implements IEstateAgent {

    @Override
    public double EstateAgentSales(double[] propertySales) {
        double total = 0;
        for (double sale : propertySales) {
            total += sale;
        }
        return total;
    }

    @Override
    public double EstateAgentCommission(double propertySales) {
        // 2% commission
        return propertySales * 0.02;
    }

    @Override
    public int TopEstateAgent(double[] totalSales) {
        // Returns the index of the agent with the highest sales
        int maxIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
