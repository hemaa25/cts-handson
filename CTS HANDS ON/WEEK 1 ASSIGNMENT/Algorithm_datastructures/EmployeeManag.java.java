import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " - " + name + " - " + position + " - ₹" + salary;
    }
}

public class EmployeeManag {
    static Employee[] employees = new Employee[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Position: ");
        String position = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        employees[count++] = new Employee(id, name, position, salary);
        System.out.println("Employee added.");
    }

    public static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Found: " + employees[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Employee not found.");
    }

    public static void viewAllEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        boolean deleted = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                deleted = true;
                System.out.println("Employee deleted.");
                break;
            }
        }
        if (!deleted) System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1) addEmployee();
            else if (choice == 2) searchEmployee();
            else if (choice == 3) viewAllEmployees();
            else if (choice == 4) deleteEmployee();
            else if (choice == 5) break;
            else System.out.println("Invalid choice.");
        }
    }
}
