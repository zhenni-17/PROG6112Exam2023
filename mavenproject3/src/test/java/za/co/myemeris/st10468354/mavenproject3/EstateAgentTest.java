package za.co.myemeris.st10468354.mavenproject3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstateAgentTest {

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        EstateAgent ea = new EstateAgent();
        double[] joeSales = {800000.0, 1500000.0, 2000000.0};
        assertEquals(4300000.0, ea.EstateAgentSales(joeSales), 0.01, "Total sales should be 4.3 million");
    }

    @Test
    public void CalculateTotalCommission_ReturnsCommission() {
        EstateAgent ea = new EstateAgent();
        // 2% of 4,300,000 is 86,000
        assertEquals(86000.0, ea.EstateAgentCommission(4300000.0), 0.01, "Commission should be 86,000");
    }

    @Test
    public void TopAgent_ReturnsTopPosition() {
        EstateAgent ea = new EstateAgent();
        double[] totals = {4300000.0, 3500000.0}; // Joe vs Jane
        assertEquals(0, ea.TopEstateAgent(totals), "Joe Bloggs (index 0) should be the top agent");
    }
}
