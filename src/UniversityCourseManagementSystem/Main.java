package UniversityCourseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create Students
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John Doe"));
        students.add(new Student(2, "Jane Smith"));
        students.add(new Student(3, "Mark Brown"));

        // Step 2: Create Courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CSE101", "Programming", "Prof. Smith"));
        courses.add(new Course("CSE102", "Databases", "Prof. Brown"));
        courses.add(new Course("CSE103", "Networking", "Prof. Taylor"));

        // Step 3: Create Enrollments
        List<Enrollment> enrollments = new ArrayList<>();
        enrollments.add(new Enrollment(1, "CSE101"));
        enrollments.add(new Enrollment(1, "CSE102"));
        enrollments.add(new Enrollment(2, "CSE101"));
        enrollments.add(new Enrollment(3, "CSE103"));

        // Step 4: Display Normalized Data
        System.out.println("Normalized Data:");

        System.out.println("\nStudents Table:");
        students.forEach(System.out::println);

        System.out.println("\nCourses Table:");
        courses.forEach(System.out::println);

        System.out.println("\nEnrollments Table:");
        enrollments.forEach(System.out::println);

        // Step 5: Join and Display Results
        System.out.println("\nFull Enrollments (Joined Data):");
        for (Enrollment enrollment : enrollments) {
            Student student = students.stream()
                    .filter(s -> s.getStudentId() == enrollment.getStudentId())
                    .findFirst()
                    .orElse(null);
            Course course = courses.stream()
                    .filter(c -> c.getCourseId().equals(enrollment.getCourseId()))
                    .findFirst()
                    .orElse(null);

            if (student != null && course != null) {
                System.out.println("Student: " + student.getStudentName() + ", Course: " + course.getCourseName() +
                        ", Instructor: " + course.getInstructor());
            }
        }
    }
}