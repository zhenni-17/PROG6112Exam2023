package za.co.myemeris.st10468354.question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstateAgentTest {

    @Test
    public void CalculateCommission_CalculatedSuccessfully() {
        EstateAgent ea = new EstateAgent();
        // 800,000 at 10% = 80,000
        assertEquals(80000.0, ea.CalculateCommission("800000", "10"), 0.01, "Should correctly calculate 80,000");
    }

    @Test
    public void CalculateCommission_CalculatedUnSuccessfully() {
        EstateAgent ea = new EstateAgent();
        // Supplying letters should catch the error and return 0
        assertEquals(0.0, ea.CalculateCommission("abc", "10"), 0.01, "Should return 0 for invalid input");
    }

    @Test
    public void ValidationTest() {
        EstateAgent ea = new EstateAgent();
        
        // Valid data
        Data valid = new Data("Cape Town", "Joe Bloggs", "800000", "10");
        assertTrue(ea.ValidateData(valid), "Valid data should pass");

        // Invalid property price (negative)
        Data invalidPrice = new Data("Cape Town", "Joe Bloggs", "-5000", "10");
        assertFalse(ea.ValidateData(invalidPrice), "Negative price should fail");
    }
}
