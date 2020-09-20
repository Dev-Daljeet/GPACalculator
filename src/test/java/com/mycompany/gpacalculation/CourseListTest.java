package com.mycompany.gpacalculation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Tests the class CourseList.
 */
class CourseListTest {

    /** Tests the addCourse() method. Test will pass if exception for 'Invalid number of courses' is thrown by the
     *  addCourse() method.
     */
    @Test
    public void exceptionForNumOfCoursesShouldBEThrown() {
        CourseList courseList = new CourseList();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            courseList.addCourse(-4);                // Negative or Invalid number of courses
        });

        String result = exception.getMessage();
        String expResult = "Invalid number of courses";

        assertEquals(expResult,result);
    }
}