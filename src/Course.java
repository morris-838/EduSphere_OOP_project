import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
    private String description;
    private Instructor instructor;
    private ArrayList<Student> students=new ArrayList<>();
    public Course(String courseID, String courseName, String description, Instructor instructor){
        this.courseID=courseID;
        this.courseName=courseName;
        this.description=description;
        this.instructor=instructor;
    }
    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Instructor getInstructor() {
        return instructor;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public void addStudent(Student student){
        students.add(student);
        System.out.println(student.getName() + " added to course: " + getCourseName());

    }
    public void publishCourse() {
        System.out.println("Course published: " + courseName);
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public String toString() {
        return "Course: " + "courseID='" + courseID + '\'' + ", courseName='" + courseName + '\'' + ", description='" + description + '\'' + ", instructor=" + instructor + ", students=" + students + '}';
    }
}
