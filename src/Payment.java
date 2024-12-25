public class Payment {
    private int paymentId;
    private Student student;
    private double amount;
    private String status;
    public Payment(int paymentId, Student student, double amount, String status) {
        this.paymentId = paymentId;
        this.student = student;
        this.amount = amount;
        this.status = status;
    }
    public void processPayment() {
        this.status = "Completed";
        System.out.println("Payment processed for " + student.getName() + ": $" + amount);
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
