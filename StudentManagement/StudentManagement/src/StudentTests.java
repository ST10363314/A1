import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

import studentmanagement.Student;


public class StudentTests {
    
    @Test
    public void testSaveStudent() {
        Student student = new Student("123", "John Doe", 18, "john@example.com", "Computer Science");
        Student.saveStudent(student);

        // Check if the student was saved correctly
        Student savedStudent = Student.searchStudent("123");
        assertNotNull(savedStudent);
        assertEquals("123", savedStudent.getStudentId());
        assertEquals("John Doe", savedStudent.getName());
        assertEquals(18, savedStudent.getAge());
        assertEquals("john@example.com", savedStudent.getEmail());
        assertEquals("Computer Science", savedStudent.getCourse());
    }

    @Test
    public void testSearchStudent() {
        Student student = new Student("123", "John Doe", 18, "john@example.com", "Computer Science");
        Student.saveStudent(student);

        // Check if searching for a valid student returns correct details
        Student foundStudent = Student.searchStudent("123");
        assertNotNull(foundStudent);
        assertEquals("123", foundStudent.getStudentId());
        assertEquals("John Doe", foundStudent.getName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Check if searching for an invalid student returns null
        Student foundStudent = Student.searchStudent("456");
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("123", "John Doe", 18, "john@example.com", "Computer Science");
        Student.saveStudent(student);

        // Check if deleting a valid student returns true
        boolean deleted = Student.deleteStudent("123");
        assertTrue(deleted);

        // Check if the student was actually deleted
        Student deletedStudent = Student.searchStudent("123");
        assertNull(deletedStudent);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Check if deleting an invalid student returns false
        boolean deleted = Student.deleteStudent("456");
        assertFalse(deleted);
    }
}
    

