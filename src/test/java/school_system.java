import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import school_system.Student;
import school_system.Teacher;
import school_system.Classroom;
import school_system.SchoolController;

class TestSchoolController {
    private SchoolController controller;
    private Classroom science_01;
    private Classroom science_02;
    private Student student;

    @BeforeEach
    void setUp() {
        controller = new SchoolController();
        science_01 = controller.createClassroom("Science-01");
        science_02 = controller.createClassroom("Science-02");
        student = new Student("Zach", 98.5);
        science_01.addStudent(student);
    }
    @Test
    void test_getClassrooms() {
        List<String> expected = new ArrayList<>(Arrays.asList("Science-01", "Science-02"));
        assertEquals(controller.getClassrooms(), expected);
    }
    @Test
    void test_transferStudent() {
        String transfer_str = controller.transferStudent(student, science_01, science_02);
        assertEquals(transfer_str, "Zach transferred from Science-01 to Science-02.");
    }
}

class TestClassroom {
    private Classroom classroom;
    private Teacher teacher;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        classroom = new Classroom("English 1010");
        teacher = new Teacher("Kris Lane", "English");
        student1 = new Student("Hannah", 70.5);
        student2 = new Student("Zach", 90.0);
        classroom.assignTeacher(teacher);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
    }
    @Test
    void test_getName() {
        assertEquals(classroom.getName(), "English 1010");
    }
    @Test
    void test_getTeacher() {
        assertEquals(classroom.getTeacher().getName(), "Kris Lane");
    }
    @Test
    void test_getAverageGrade() {
        double average = (70.5 + 90.0) / 2;
        assertEquals(classroom.getAverageGrade(), average, 0.001);
    }
}