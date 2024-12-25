public class Feedback {

    private int feedbackID;
    private Student student;
    private Course course;
    private int rating;
    private String comments;

    public Feedback(int feedbackId, Student student, Course course, int rating, String comments) {
        this.feedbackID = feedbackId;
        this.student = student;
        this.course = course;
        this.rating = rating;
        this.comments = comments;
    }


    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating <= 5 && rating >= 0) {
            this.rating = rating;
        }
    }

    public void submitFeedback() {
        System.out.println("Feedback submitted for course: " + course.getCourseName());
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Comments: " + comments);
    }
}
