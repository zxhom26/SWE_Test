// SchoolSystem.java
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
}


class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String assignGrade(Student student, double newGrade) {
        student.setGrade(newGrade);
        return this.name + " assigned grade " + newGrade + " to " + student.getName() + ".";
    }

    public String getName() { return name; }
    public String getSubject() { return subject; }
}


class Classroom {
    private String name;
    private List<Student> students;
    private Teacher teacher;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() { return name; }
    public Teacher getTeacher() { return teacher; }
    public List<Student> getStudents() { return students; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getAverageGrade() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }
        return total / students.size();
    }
}


class SchoolController {
    private List<Classroom> classrooms;

    public SchoolController() {
        this.classrooms = new ArrayList<>();
    }

    public Classroom createClassroom(String name) {
        Classroom classroom = new Classroom(name);
        classrooms.add(classroom);
        return classroom;
    }

    public String transferStudent(Student student, Classroom fromClass, Classroom toClass) {
        if (fromClass.getStudents().contains(student)) {
            fromClass.getStudents().remove(student);
            toClass.getStudents().add(student);
            return student.getName() + " transferred from " + fromClass.getName() + " to " + toClass.getName() + ".";
        } else {
            throw new IllegalArgumentException(student.getName() + " not found in " + fromClass.getName());
        }
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }
}
