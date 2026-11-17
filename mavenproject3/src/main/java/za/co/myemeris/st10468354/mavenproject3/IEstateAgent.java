package za.co.myemeris.st10468354.mavenproject3;

public interface IEstateAgent {
    double EstateAgentSales(double[] propertySales);
    double EstateAgentCommission(double propertySales);
    int TopEstateAgent(double[] totalSales);
}
