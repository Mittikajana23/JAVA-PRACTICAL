//Create a class named “Employee” to store information of an employee (emp_no, name, department, basic_pay, DA, HRA and gross_salary). Write a program, which will take as input the  emp_no, name, department, basic_pay for several employees. The program will calculate the DA, HRA and total for each employee and display the details of the employee having the highest gross salary.
import java.util.Scanner;
class Employee {
    int emp_no;
    String name;
    String department;
    double basic_pay;
    double DA;
    double HRA;
    double gross_salary;
    public void calculateSalary() {
        DA = 0.40 * basic_pay;
        HRA = 0.20 * basic_pay;
        gross_salary = basic_pay + DA + HRA;
    }
    public void displayDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Employee Number : " + emp_no);
        System.out.println("Name            : " + name);
        System.out.println("Department      : " + department);
        System.out.println("Basic Pay       : " + basic_pay);
        System.out.println("DA (40%)        : " + DA);
        System.out.println("HRA (20%)       : " + HRA);
        System.out.println("Gross Salary    : " + gross_salary);
        System.out.println("----------------------------------------");
    }
}
public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Invalid number of employees.");
            scanner.close();
            return;
        }
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            employees[i] = new Employee();
            System.out.print("Employee No: ");
            employees[i].emp_no = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            employees[i].name = scanner.nextLine();
            System.out.print("Department: ");
            employees[i].department = scanner.nextLine();
            System.out.print("Basic Pay: ");
            employees[i].basic_pay = scanner.nextDouble();
            employees[i].calculateSalary();
        }
        Employee highestPaid = employees[0];
        for (int i = 1; i < n; i++) {
            if (employees[i].gross_salary > highestPaid.gross_salary) {
                highestPaid = employees[i];
            }
        }
        System.out.println("\n=== Employee with the Highest Gross Salary ===");
        highestPaid.displayDetails();
        scanner.close();
    }
}
