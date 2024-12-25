import java.util.*;
public class Student extends User{
    public Student(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    private ArrayList<Course> enrolledCourses = new ArrayList<>();
    private ArrayList<Integer> progress = new ArrayList<>();


    public void viewCourses() {
        System.out.println("Courses enrolled by: " + getName());
        for (Course course : enrolledCourses) {
            System.out.println(course.getCourseName());
        }
    }
    public void completeQuiz(Quiz quiz) {
        System.out.println(getName() + " completed Quiz ID: " + quiz.getQuizId());
    }

    // Enroll in a new course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        progress.add(0); // Initialize progress for the new course
        System.out.println(getName() + " enrolled in course: " + course.getCourseName());
    }
    public String toString() {
        return "Student{" +"id=" + getId() +", name='" + getName() + '\'' + ", email='" + getEmail() + '\'' +", password='" + getPassword() + '\''  +
                "enrolledCourses=" + enrolledCourses +
                ", progress=" + progress +
                '}';
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public ArrayList<Integer> getProgress() {
        return progress;
    }

    public void setProgress(ArrayList<Integer> progress) {
        this.progress = progress;
    }
}
