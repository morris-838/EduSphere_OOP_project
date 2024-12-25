public class Certification {
    private int certID;
    private Student student;
    private Course course;
    private String dateIssued;
    public Certification(int certID, Student student, Course course, String dateIssued) {
        this.certID = certID;
        this.student = student;
        this.course = course;
        this.dateIssued = dateIssued;
    }

    public int getCertID() {
        return certID;
    }

    public void setCertID(int certID) {
        this.certID = certID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

    public void generateCertification(){
        System.out.println("Certification ID: " + certID);
        System.out.println("Issued to: " + student.getName());
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Date: " + dateIssued);
    }


}
