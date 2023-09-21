/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;
import java.util.ArrayList;
public class Student {

    private String studentId;
    private String name;
    private int age;
    private String email;
    private String course;

    // Constructor
    public Student(String studentId, String name, int age, String email, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters and setters for student attributes (name, age, email, course)

    // Create an ArrayList to store students
    private static ArrayList<Student> studentList = new ArrayList<>();

    // Method to save a student
    public static void saveStudent(Student student) {
        studentList.add(student);
    }
    
     public String getStudentId() {
        return studentId;
    }
     
       public String getName() {
        return name;
    }

       public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
    // Method to search for a student by student ID
    public static Student searchStudent(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to delete a student by student ID
    public static boolean deleteStudent(String studentId) {
        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            return true; // Student deleted successfully
        } else {
            return false; // Student not found
        }
    }

    // Method to generate a student report
    public static void studentReport() {
        for (Student student : studentList) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println("---------------------------");
        }
    }

    // Method to exit the application
    public static void exitStudentApplication() {
        // Implement exit logic here
    }
}

   
    
    
    

