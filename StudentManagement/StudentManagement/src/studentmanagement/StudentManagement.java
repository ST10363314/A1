/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagement {

    
    public static void main(String[] args) {
        
          Scanner scanner = new Scanner(System.in);
             System.out.println("Welcome The Student Management Application:");
                System.out.println("******************************************");
        while (true) {
            // Display menu
            System.out.println("Menu:");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View student report");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Capture a new student
                    captureNewStudent();
                    break;
                case 2:
                    // Search for a student
                    searchForStudent();
                    break;
                case 3:
                    // Delete a student
                    deleteStudent();
                    break;
                case 4:
                    // View student report
                    Student.studentReport();
                    break;
                case 5:
                    // Exit the application
                    Student.exitStudentApplication();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private static void captureNewStudent() {
         Scanner scanner = new Scanner(System.in);

    System.out.println("Enter student ID:");
    String studentId = scanner.nextLine();

    System.out.println("Enter student name:");
    String name = scanner.nextLine();

    int age;
    while (true) {
        System.out.println("Enter student age:");
        try {
            age = Integer.parseInt(scanner.nextLine());
            if (age >= 16) {
                break; // Age is valid, exit the loop
            } else {
                System.out.println("Invalid age. Age must be greater than or equal to 16.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid age (numeric).");
        }
    }

    System.out.println("Enter student email:");
    String email = scanner.nextLine();

    System.out.println("Enter student course:");
    String course = scanner.nextLine();

    // Create a new Student object and save it
    Student student = new Student(studentId, name, age, email, course);
    Student.saveStudent(student);

    System.out.println("Student details have been successfully saved.");
    }

    private static void searchForStudent() {
        Scanner scanner = new Scanner(System.in);

    System.out.println("Enter student ID to search:");
    String studentId = scanner.nextLine();

    Student foundStudent = Student.searchStudent(studentId);

    if (foundStudent != null) {
        // Student found, display details
        System.out.println("Student details:");
        System.out.println("Student ID: " + foundStudent.getStudentId());
        System.out.println("Name: " + foundStudent.getName());
        System.out.println("Age: " + foundStudent.getAge());
        System.out.println("Email: " + foundStudent.getEmail());
        System.out.println("Course: " + foundStudent.getCourse());
    } else {
        // Student not found
        System.out.println("Student not found.");
    }
    }

    private static void deleteStudent() {
         Scanner scanner = new Scanner(System.in);

    System.out.println("Enter student ID to delete:");
    String studentId = scanner.nextLine();

    boolean deleted = Student.deleteStudent(studentId);

    if (deleted) {
        // Student deleted successfully
        System.out.println("Student with ID " + studentId + " has been deleted.");
    } else {
        // Student not found
        System.out.println("Student with ID " + studentId + " not found. Deletion failed.");
    }
    }
        
    }
    
