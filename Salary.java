//Write a program to implement the Multiple Inheritance kind of framework (Gross Interface, Employee & Salary classes).

// Write a program to implement the Multiple Inheritance kind of framework
// (Gross Interface, Employee & Salary classes).

interface Gross {
    void calculate();
}

class Employee {
    int emp_no;
    String name;

    Employee(int emp_no, String name) {
        this.emp_no = emp_no;
        this.name = name;
    }
}

public class Salary extends Employee implements Gross {
    double basic_pay, DA, HRA, gross_salary;

    Salary(int emp_no, String name, double basic_pay) {
        super(emp_no, name);
        this.basic_pay = basic_pay;
    }

    public void calculate() {
        DA = basic_pay * 0.10;
        HRA = basic_pay * 0.20;
        gross_salary = basic_pay + DA + HRA;
    }

    void display() {
        System.out.println("Employee Number: " + emp_no);
        System.out.println("Name: " + name);
        System.out.println("Basic Pay: " + basic_pay);
        System.out.println("DA: " + DA);
        System.out.println("HRA: " + HRA);
        System.out.println("Gross Salary: " + gross_salary);
    }

    public static void main(String[] args) {
        Salary s = new Salary(101, "Rahul", 30000);

        s.calculate();
        s.display();
    }
}