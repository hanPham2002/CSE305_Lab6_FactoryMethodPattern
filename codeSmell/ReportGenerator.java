import java.util.*;

// Tách class Owner riêng để tránh Data Clump
class Owner {
    private String name;
    private String location;

    public Owner(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

// Property chỉ giữ dữ liệu
class Property {
    private String name;
    private double rentAmount;
    private Owner owner;

    public Property(String name, double rentAmount, Owner owner) {
        this.name = name;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isPremium() {
        return rentAmount > 2000;
    }

    public double getYearlyRent() {
        return rentAmount * 12;
    }
}

// Lớp chịu trách nhiệm in thông tin Property (tách khỏi Property)
class PropertyPrinter {
    public static void print(Property property) {
        System.out.println("Property: " + property.getName());
        System.out.println("Rent Amount: $" + property.getRentAmount());
        System.out.println("Owner: " + property.getOwner().getName());
        System.out.println("Location: " + property.getOwner().getLocation());
        System.out.println(property.isPremium() ? "This is a premium property." : "This is a standard property.");
        System.out.println("Yearly Rent: $" + property.getYearlyRent());
        System.out.println("--------------------");
    }
}

// Báo cáo tài chính chỉ lo xử lý dữ liệu
class FinancialReport {
    private String reportTitle;
    private List<Property> properties;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    public void generateReport() {
        double totalRent = 0;
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");
        for (Property property : properties) {
            PropertyPrinter.print(property);
            totalRent += property.getRentAmount();
        }
        System.out.println("Total Rent Amount: $" + totalRent);
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        Owner owner1 = new Owner("John Doe", "City Center");
        Owner owner2 = new Owner("Jane Smith", "Suburb");
        Owner owner3 = new Owner("Bob Johnson", "Downtown");

        Property property1 = new Property("Apartment A", 1500.0, owner1);
        Property property2 = new Property("House B", 2000.0, owner2);
        Property property3 = new Property("Condo C", 1800.0, owner3);

        FinancialReport report = new FinancialReport("Monthly Rent Summary",
                List.of(property1, property2, property3));
        report.generateReport();
    }
}
