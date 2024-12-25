public class TrueFalseQuestion extends Question{
    private Boolean isTrue;
    public TrueFalseQuestion(int questionId, String text, int marks, boolean isTrue) {
        super(questionId, text, marks);
        this.isTrue = isTrue;
    }
    @Override
    public void display() {
        System.out.println("Question: " + getText());
        System.out.println("1. True");
        System.out.println("2. False");
    }
    public boolean isCorrect(boolean answer) {
        return answer == isTrue;
    }
}



