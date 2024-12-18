package UniversityCourseManagementSystem;

public class Enrollment {
    private int studentId;
    private String courseId;

    public Enrollment(int studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentId + ", CourseID: " + courseId;
    }
}