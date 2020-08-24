//Package entity class (Done by Jacqueline)
import java.util.Date;

public class Package {
    private static String description;
    private static String packageCode;
    private static double packageAmount;
    private static Date startDate;
    private static Date endDate;
    private static boolean isAvailable;
    
    public Package(String packageCode, String description, double packageAmount, 
            Date startDate, Date endDate, boolean isAvailable) {
        this.description = description;
        this.packageCode = packageCode;
        this.packageAmount = packageAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAvailable = true;
    }
    
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

 

    public double getPackageAmount() {
        return packageAmount;
    }

 

    public void setPackageAmount(double packageAmount) {
        this.packageAmount = packageAmount;
    }

 

    public void setDescription(String description) {
        this.description = description;
    }

 

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

 

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

 

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

 

    public static String showAvailability(boolean isAvailable) {
        String avail;

 

        if (isAvailable == true) {
            avail = "Yes";
        } else {
            avail = "No";
        }
        return avail;
    }
    
    public static void display() {
        System.out.println("Package code: " + packageCode);
        System.out.println("Description: " + description);
        System.out.println("Start date: " + startDate);
        System.out.println("End date: " + endDate);
        System.out.println("Amount: " + packageAmount);
        System.out.println("Availability: " + showAvailability(isAvailable));
    }
}