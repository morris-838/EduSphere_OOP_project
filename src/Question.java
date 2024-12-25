public abstract class Question {
    private int questionId;
    private String text;
    public int marks;
    public String getText() {
        return this.text;
    }
    public Question(int questionId, String text, int marks) {
        this.questionId = questionId;
        this.text = text;
        this.marks = marks;
    }
    public abstract void display();
    public int getQuestionId() {
        return this.questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public int getMarks() {
        return this.marks;
    }
}


