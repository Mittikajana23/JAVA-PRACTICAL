//Create a class called Employee. Employee has three private data members name, department and salary. Initialize these data member via constructor. Display all the information for 5 employee of same company. Also display name of their company. Use static member concept to implement this code
class Employee {
    private String name;
    private String department;
    private double salary;
    private static String companyname;
public Employee (String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
} 
public static void setCompanyName(String cname) {
        companyname = cname;
}
public void displayInfo() {
        System.out.println("Company: " + companyname);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("------------------------");
    }
}
public class main {
    public static void main(String[] args) {
        Employee.setCompanyName("T.L.S. Pvt. Ltd.");
         Employee e1 = new Employee("Pritam", "HR", 75000);
        Employee e2 = new Employee("Arna", "Finance", 65000);
        Employee e3 = new Employee("Prateek", "R&D", 60000);
        Employee e4 = new Employee("Mani", "Marketing", 60000);
        Employee e5 = new Employee("Mandal", "Operations", 60000);
    e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();
        e4.displayInfo();
        e5.displayInfo();
    }
}
