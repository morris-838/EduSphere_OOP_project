public class Notification{
    private int notificationId;
    private User user;
    private String message;
    public Notification(int notificationId, User user, String message) {
        this.notificationId = notificationId;
        this.user = user;
        this.message = message;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendNotification() {
        System.out.println("Notification sent to " + user.getName() + ": " + message);
    }

}
