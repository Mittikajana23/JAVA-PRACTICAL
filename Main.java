//Interface Department, Hostel Class and Student Class (Menu Driven Program)

import java.util.Scanner;

interface Department {
    String deptName = "";
    String deptHead = "";

    void printDeptName();
    void printDeptHead();
}

class Hostel {
    String hostelName;
    String hostelLocation;
    int numberofRooms;

    void getHostelData(Scanner sc) {
        System.out.print("Enter Hostel Name: ");
        hostelName = sc.nextLine();

        System.out.print("Enter Hostel Location: ");
        hostelLocation = sc.nextLine();

        System.out.print("Enter Number of Rooms: ");
        numberofRooms = sc.nextInt();
        sc.nextLine();
    }

    void printHostelData() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Hostel Location: " + hostelLocation);
        System.out.println("Number of Rooms: " + numberofRooms);
    }
}

class Student extends Hostel implements Department {
    String studentName;
    int regdNo;
    String electiveSubject;
    double avgMarks;

    String departmentName;
    String departmentHead;

    void getData(Scanner sc) {
        System.out.print("Enter Student Name: ");
        studentName = sc.nextLine();

        System.out.print("Enter Registration Number: ");
        regdNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Elective Subject: ");
        electiveSubject = sc.nextLine();

        System.out.print("Enter Average Marks: ");
        avgMarks = sc.nextDouble();
        sc.nextLine();

        getHostelData(sc);

        System.out.print("Enter Department Name: ");
        departmentName = sc.nextLine();

        System.out.print("Enter Department Head: ");
        departmentHead = sc.nextLine();
    }

    public void printDeptName() {
        System.out.println("Department Name: " + departmentName);
    }

    public void printDeptHead() {
        System.out.println("Department Head: " + departmentHead);
    }

    void printData() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Student Name: " + studentName);
        System.out.println("Registration Number: " + regdNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks: " + avgMarks);

        printHostelData();
        printDeptName();
        printDeptHead();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Admit New Student");
            System.out.println("2. Migrate a Student");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (count < students.length) {
                        students[count] = new Student();
                        students[count].getData(sc);
                        count++;
                        System.out.println("Student Admitted Successfully!");
                    } else {
                        System.out.println("Student Limit Reached!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Registration Number: ");
                    int reg = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].regdNo == reg) {
                            System.out.println("Enter New Hostel Details");
                            students[i].getHostelData(sc);
                            System.out.println("Student Migrated Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No Student Records Found!");
                    } else {
                        for (int i = 0; i < count; i++) {
                            students[i].printData();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}