/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

/**
 *
 * @author Oletl
 */
import java.util.Scanner;

class Task {
    private String title;
    private String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager(int maxTasks) {
        tasks = new Task[maxTasks];
        taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = task;
            taskCount++;
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Task manager is full. Cannot add more tasks.");
        }
    }

    public void listTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("-----------------------");
        }
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(10); // Maximum of 10 tasks

        while (true) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(title, description);
                    taskManager.addTask(task);
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");// (www.w3schools.com, n.d.)
            }
        }
    }
}
//www.w3schools.com. (n.d.). Java switch Keyword. [online] Available at: https://www.w3schools.com/java/ref_keyword_switch.asp [Accessed 20 Sep. 2023].

