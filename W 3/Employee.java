class EmployeeDetails {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeDetails(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeDetails(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName
                + " | Rs " + salary
                + " | Intern: " + isIntern);
    }
}

public class Employee {

    public static void main(String[] args) {

        EmployeeDetails permanent = new EmployeeDetails(
                "E-101", "Divya", 65000
        );

        EmployeeDetails intern = new EmployeeDetails(
                "E-102", "Arjun"
        );

        permanent.printProfile();
        intern.printProfile();
    }
}