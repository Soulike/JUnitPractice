import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseTest
{
    private Course course = null;

    @BeforeEach
    void beforeEach()
    {
        course = new Course("Math");
    }

    // Tests below test the functions of Course

    // Switch between unassigned and assigned
    @Test
    void unassignedAndAssigned()
    {
        assertFalse(course.isAssigned(), "Should be unassigned before adding professor");
        course.addProcessor();
        assertTrue(course.isAssigned(), "Should be assigned after adding professor");
        course.removeProcessor();
        assertFalse(course.isAssigned(), "Should be unassigned after removing professor");
    }

    // Set to full when unassigned
    @Test
    void fullWhenUnassigned()
    {
        assertFalse(course.isFull(), "Should not be full before adding student");
        course.addStudent();
        assertFalse(course.isFull(), "Should not be full after adding only 1 student");
        for (int i = 0; i < 8; i++) // add 8 students
        {
            course.addStudent();
        }
        assertFalse(course.isFull(), "Should not be full after adding only 9 students");
        course.addStudent();
        assertTrue(course.isFull(), "Should be full after adding 10 students");
        course.removeStudent();
        assertFalse(course.isFull(), "Should not be full after remove 1 student");
    }

    // Set to full when assigned
    @Test
    void fullWhenAssigned()
    {
        course.addProcessor();  // Set course to assigned
        assertFalse(course.isFull(), "Should not be full before adding student");
        course.addStudent();
        assertFalse(course.isFull(), "Should not be full after adding only 1 student");
        for (int i = 0; i < 8; i++) // add 8 students
        {
            course.addStudent();
        }
        assertFalse(course.isFull(), "Should not be full after adding only 9 students");
        course.addStudent();
        assertTrue(course.isFull(), "Should be full after adding 10 students");
        course.removeStudent();
        assertFalse(course.isFull(), "Should not be full after remove 1 student");
    }

    // Call closeRegistration when unassigned
    @Test
    void unassignedCloseRegistration()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling closeRegistration when unassigned");
        course.closeRegistration();
        assertTrue(course.isCanceled(), "Should be canceled after calling closeRegistration when unassigned");
    }

    // Call close when unassigned
    @Test
    void unassignedClose()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling close when unassigned");
        course.close();
        assertTrue(course.isCanceled(), "Should be canceled after calling close when unassigned");
    }

    // Call cancel when unassigned
    @Test
    void unassignedCancel()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling cancel when unassigned");
        course.cancel();
        assertTrue(course.isCanceled(), "Should be canceled after calling cancel when unassigned");
    }

    // Call cancel when assigned
    @Test
    void assignedCancelWhenNumStudentLessThan3()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling cancel");
        course.addProcessor();
        for (int i = 0; i < 2; i++)    // add 2 students
        {
            course.addStudent();
        }
        course.cancel();
        assertTrue(course.isCanceled(), "Should be canceled after calling cancel");
    }

    @Test
    void assignedCancelWhenNumStudentGreaterEqual3()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling cancel");
        course.addProcessor();
        for (int i = 0; i < 3; i++)    // add 3 students
        {
            course.addStudent();
        }
        course.cancel();
        assertTrue(course.isCanceled(), "Should be canceled after calling cancel");
    }

    // Call close when assigned
    @Test
    void assignedCloseWhenNumStudentLessThan3()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling close when students' amount is less than 3");
        assertFalse(course.isCommitted(), "Should not be committed before calling close when students' amount is less than 3");
        course.addProcessor();
        for (int i = 0; i < 2; i++)    // add 2 students
        {
            course.addStudent();
        }
        course.close();
        assertTrue(course.isCanceled(), "Should be canceled after calling close when students' amount is less than 3");
        assertFalse(course.isCommitted(), "Should not be committed after calling close when students' amount is less than 3");
    }

    // Call closeRegistration when assigned
    @Test
    void assignedCloseWhenNumStudentGreaterEqualThan3()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling close when students' amount is greater equal than 3");
        assertFalse(course.isCommitted(), "Should not be committed before calling close when students' amount is greater equal than 3");
        course.addProcessor();
        for (int i = 0; i < 3; i++)    // add 3 students
        {
            course.addStudent();
        }
        course.close();
        assertFalse(course.isCanceled(), "Should not be canceled after calling close when students' amount is greater equal than 3");
        assertTrue(course.isCommitted(), "Should be committed after calling close when students' amount is greater equal than 3");
    }

    @Test
    void assignedCloseRegistrationWhenNumStudentGreaterEqualThan3()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling close when students' amount is greater equal than 3");
        assertFalse(course.isCommitted(), "Should not be committed before calling close when students' amount is greater equal than 3");
        course.addProcessor();
        for (int i = 0; i < 3; i++)    // add 3 students
        {
            course.addStudent();
        }
        course.closeRegistration();
        assertFalse(course.isCanceled(), "Should not be canceled after calling close when students' amount is greater equal than 3");
        assertTrue(course.isCommitted(), "Should be committed after calling close when students' amount is greater equal than 3");
    }

    // Call cancel when full
    @Test
    void fullCancel()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling cancel");
        assertFalse(course.isCommitted(), "Should not be canceled before calling cancel");
        for (int i = 0; i < 10; i++)   // add 10 students, setting course to full
        {
            course.addStudent();
        }
        course.cancel();
        assertTrue(course.isCanceled(), "Should be canceled after calling cancel");
        assertFalse(course.isCommitted(), "Should not be canceled after calling cancel");

    }

    // Call close when full
    @Test
    void fullClose()
    {
        assertFalse(course.isCanceled(), "Should not be canceled before calling close");
        assertFalse(course.isCommitted(), "Should not be committed before calling close");
        for (int i = 0; i < 10; i++)   // add 10 students, setting course to full
        {
            course.addStudent();
        }
        course.close();
        assertFalse(course.isCanceled(), "Should not be canceled after calling close");
        assertTrue(course.isCommitted(), "Should be committed after calling close");
    }

    // Call closeRegistration when full
    @Test
    void fullCloseRegistration()
    {
        course.addProcessor();  // Set course to assigned
        assertFalse(course.isCanceled(), "Should not be canceled before calling closeRegistration");
        assertFalse(course.isCommitted(), "Should not be committed before calling closeRegistration");
        for (int i = 0; i < 10; i++)   // add 10 students, setting course to full
        {
            course.addStudent();
        }
        course.closeRegistration();
        assertFalse(course.isCanceled(), "Should not be canceled after calling closeRegistration");
        assertTrue(course.isCommitted(), "Should be committed after calling closeRegistration");
    }

    // Tests below can cover maximum states in one test
    @Test
    void toCommitted()
    {
        course.addProcessor();
        assertTrue(course.isAssigned(), "Should be assigned after adding professor");
        for (int i = 0; i < 10; i++)
        {
            course.addStudent();
        }
        assertTrue(course.isFull(), "Should be full after adding 10 students");
        course.close();
        assertTrue(course.isCommitted(), "Should be committed after calling close when student >= 3");
    }

    @Test
    void toCancel()
    {
        course.addProcessor();
        assertTrue(course.isAssigned(), "Should be assigned after adding professor");
        for (int i = 0; i < 10; i++)
        {
            course.addStudent();
        }
        assertTrue(course.isFull(), "Should be full after adding 10 students");
        course.cancel();
        assertTrue(course.isCanceled(), "Should be canceled after calling cancel");
    }
}
