package za.co.myemeris.st10468354.question2;

public class Data {
    private String location;
    private String name;
    private String propertyPrice;
    private String commissionPercentage;

    public Data(String location, String name, String propertyPrice, String commissionPercentage) {
        this.location = location;
        this.name = name;
        this.propertyPrice = propertyPrice;
        this.commissionPercentage = commissionPercentage;
    }

    public String getLocation() { return location; }
    public String getName() { return name; }
    public String getPropertyPrice() { return propertyPrice; }
    public String getCommissionPercentage() { return commissionPercentage; }
}