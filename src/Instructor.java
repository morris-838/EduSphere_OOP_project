import java.util.*;
public class Instructor extends User{
    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    private ArrayList<Course> createdCourses = new ArrayList<>();
    private String specialization;

    public void createCourse(Course course) {
        createdCourses.add(course);
        System.out.println("Course created: " + course.getCourseName());
    }

    public void gradeQuiz(Quiz quiz, Student student) {
        System.out.println("Quiz graded by: " + getName() + " for student: " + student.getName());
    }
    public ArrayList<Course> getCreatedCourses() {
        return createdCourses;
    }
    public String toString() {
        return "Instructor{" +"id=" + getId() +", name='" + getName() + '\'' + ", email='" + getEmail() + '\'' +", password='" + getPassword() + '\''  +
                "createdCourses=" + createdCourses +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
