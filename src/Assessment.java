import java.util.ArrayList;

public class Assessment {
    private int assessmentID;
    private Course course;
    private Student student;
    private int score;
    public Assessment(){
        this.assessmentID=assessmentID;
        this.course=course;
        this.student=student;
        this.score=score;
    }

    public Assessment(int assessmentID, Course course, Student student, int score) {
        this.assessmentID=assessmentID;
        this.course=course;
        this.student=student;
        this.score=score;

    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void recordScore(int newScore){
        score=newScore;
        System.out.println("Score updated for " + student.getName() + ": " + newScore);
    }
      private static Course findCourseById(String courseId, ArrayList<Course> courses) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
    private static Student findStudentById(int studentId, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
