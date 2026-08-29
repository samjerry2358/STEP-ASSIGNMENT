class Staff {
    String staffName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int staffCount = 0;

    Staff(String staffName, double salary) {
        this.staffName = staffName;
        this.salary = salary;
        staffCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Staff on record: " + staffCount);
    }
}

public class Company {
    public static void main(String[] args) {

        Staff staff1 = new Staff("Divya", 65000);
        Staff staff2 = new Staff("Arjun", 50000);
        Staff staff3 = new Staff("Priya", 55000);

        Staff.printCompanyInfo();
    }
}