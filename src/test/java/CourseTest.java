import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseTest
{
    private Course course = null;

    @BeforeEach
    void beforeEach()
    {
        course = new Course("Math");
    }

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
