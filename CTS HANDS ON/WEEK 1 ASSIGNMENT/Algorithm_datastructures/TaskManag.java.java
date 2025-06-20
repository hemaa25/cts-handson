import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return taskId + " - " + taskName + " - " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskList {
    Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
    }

    public void traverseTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void searchTask(int id) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == id) {
                System.out.println("Found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.taskId != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted.");
        }
    }
}

public class TaskManag{
    public static void main(String[] args) {
        TaskList list = new TaskList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.print("Enter Task ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Task Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Status: ");
                String status = sc.nextLine();
                list.addTask(new Task(id, name, status));
            } else if (ch == 2) {
                System.out.print("Enter Task ID to search: ");
                int id = sc.nextInt();
                list.searchTask(id);
            } else if (ch == 3) {
                list.traverseTasks();
            } else if (ch == 4) {
                System.out.print("Enter Task ID to delete: ");
                int id = sc.nextInt();
                list.deleteTask(id);
            } else if (ch == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
