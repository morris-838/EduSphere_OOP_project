public class MultipleChoiceQuestion extends Question {
    private String[] options; // Array of options
    private String correctAnswer;
    public MultipleChoiceQuestion(int questionId, String text, int marks, String[] options, String correctAnswer) {
        super(questionId, text, marks);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void display() {
        System.out.println("Question: " + getText());
        for (int i = 0; i < options.length; i++) System.out.println((i + 1) + ". " + options[i]);
    }

    public String[] getOptions() {
        return options;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}