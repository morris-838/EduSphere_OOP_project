import java.util.ArrayList;

public class Quiz {
    private int quizId;
    private ArrayList<Question> questions = new ArrayList<>();
    private int courseId;
    public Quiz(int quizId, int courseId) {
        this.quizId = quizId;
        this.courseId = courseId;
    }
    public void addQuestion(Question question) {
        questions.add(question);
        System.out.println("Question added to Quiz ID: " + quizId);
    }
    public void generateQuestions() {
        System.out.println("Questions generated for Quiz ID: " + quizId);
    }
    public void evaluateQuiz(Student student) {
        System.out.println("Quiz evaluated for student: " + student.getName());
    }
    public int getQuizId() {
        return quizId;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }


    public int getCourseId() {
        return courseId;
    }
}
