import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        try {
            while (true) {
                Student student = DataHandler.loadStudents("students.txt",students);
                if (student == null) {
                    break;
                }
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Instructor> instructors = new ArrayList<>();
        try {
            while(true){
                Instructor instructor= DataHandler.loadInstructors("instructors.txt",instructors);
                if(instructor==null){
                    break;
                }
                instructors.add(instructor);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Course> courses = new ArrayList<>();
        try {
            while(true){
                Course course = DataHandler.loadCourses("courses.txt",courses,instructors);
                if(course==null){
                    break;
                }
                courses.add(course);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {
            Quiz quiz=DataHandler.loadQuiz("quizzes.txt",quizzes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Instructor instructor1 = new Instructor(1, "Dr. Smith", "smith@example.com", "password");
        instructors.add(instructor1);

        while (true) {
            System.out.println("\n--- Learning Management System ---");
            System.out.println("1. Create Student");
            System.out.println("2. Create Instructor");
            System.out.println("3. Create Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. View Courses of a Student");
            System.out.println("6. Create Quiz for a Course");
            System.out.println("7. Add Question to a Quiz");
            System.out.println("8. Take Quiz");
            System.out.println("9. feedback");
            System.out.println("10. View Feedbacks");
            System.out.println("11. view instructors");
            System.out.println("12. view students");
             System.out.println("13. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter Student Password: ");
                    String studentPassword = scanner.nextLine();
                    students.add(new Student(studentId, studentName, studentEmail, studentPassword));
                    try {
                        DataHandler.saveStudent(students.getLast(),"students.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Student created successfully.");
                    break;

                case 2:
                    System.out.print("Enter Instructor ID: ");
                    int instructorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Instructor Name: ");
                    String instructorName = scanner.nextLine();
                    System.out.print("Enter Instructor Email: ");
                    String instructorEmail = scanner.nextLine();
                    System.out.print("Enter Instructor Password: ");
                    String instructorPassword = scanner.nextLine();
                    instructors.add(new Instructor(instructorId, instructorName, instructorEmail, instructorPassword));
                    try {
                        DataHandler.saveInstructor(instructors.getLast(),"instructors.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Student created successfully.");
                    break;


                case 3:
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Course Description: ");
                    String courseDescription = scanner.nextLine();
                    courses.add(new Course(courseId, courseName, courseDescription, instructor1)); // Use example instructor
                    try {
                        DataHandler.saveCourse(courses.getLast(),"courses.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Course created successfully.");
                    break;

                case 4:
                    if (students.isEmpty() || courses.isEmpty()) {
                        System.out.println("No students or courses available.");
                        break;
                    }
                    System.out.println("Available Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName());
                    }
                    System.out.print("Select a student by number: ");
                    int studentIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Available Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
                    }
                    System.out.print("Select a course by number: ");
                    int courseIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (studentIndex >= 0 && studentIndex < students.size() && courseIndex >= 0 && courseIndex < courses.size()) {
                        students.get(studentIndex).enrollInCourse(courses.get(courseIndex));
                    } else {
                        System.out.println("Invalid student or course selection.");
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }
                    System.out.println("Available Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName());
                    }
                    System.out.print("Select a student by number: ");
                    studentIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (studentIndex >= 0 && studentIndex < students.size()) {
                        students.get(studentIndex).viewCourses();
                    } else {
                        System.out.println("Invalid student selection.");
                    }
                    break;
                case 6:
                    if (courses.isEmpty()) {
                        System.out.println("No courses available.");
                        break;
                    }
                    System.out.println("Available Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
                    }
                    System.out.print("Select a course by number: ");
                    int courseIndexForQuiz = scanner.nextInt() - 1;
                    scanner.nextLine();
                   if (courseIndexForQuiz >= 0 && courseIndexForQuiz < courses.size()) {
    System.out.print("Enter Quiz ID: ");
    int quizId = scanner.nextInt();
    scanner.nextLine();

    Quiz newQuiz = new Quiz(quizId, Integer.parseInt(courses.get(courseIndexForQuiz).getCourseID()));
    quizzes.add(newQuiz);

    try {
        DataHandler.saveQuiz(newQuiz, "quizzes.txt");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("Quiz created successfully.");
} else {
    System.out.println("Invalid course selection.");
}
                    break;

                case 7:
                    if (quizzes.isEmpty()) {
                        System.out.println("No quizzes available.");
                        break;
                    }
                    System.out.println("Available Quizzes:");
                    for (int i = 0; i < quizzes.size(); i++) {
                        System.out.println((i + 1) + ". Quiz ID: " + quizzes.get(i).getQuizId());
                    }
                    System.out.print("Select a quiz by number: ");
                    int quizIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (quizIndex >= 0 && quizIndex < quizzes.size()) {
                        System.out.print("Enter Question ID: ");
                        int questionId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Question Text: ");
                        String questionText = scanner.nextLine();
                        System.out.print("Enter Marks for the Question: ");
                        int marks = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Is the answer True or False? (true/false): ");
                        boolean isTrue = scanner.nextBoolean();
                        scanner.nextLine();
                        quizzes.get(quizIndex).addQuestion(new TrueFalseQuestion(questionId, questionText, marks, isTrue));
                        System.out.println("Question added to quiz successfully.");
                        System.out.println("Note: questions are not saved on rerun!");
                    } else {
                        System.out.println("Invalid quiz selection.");
                    }
                    break;
                case 8:
                    if (students.isEmpty() || quizzes.isEmpty()) {
                        System.out.println("No students or quizzes available.");
                        break;
                    }
                    System.out.println("Available Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName());
                    }
                    System.out.print("Select a student by number: ");
                    int studentIndex2 = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Available Quizzes:");
                    for (int i = 0; i < quizzes.size(); i++) {
                        System.out.println((i + 1) + ". Quiz ID: " + quizzes.get(i).getQuizId());
                    }
                    System.out.print("Select a quiz by number: ");
                    int quizIndex2 = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (studentIndex2 >= 0 && studentIndex2 < students.size() && quizIndex2 >= 0 && quizIndex2 < quizzes.size()) {
                        Quiz selectedQuiz = quizzes.get(quizIndex2);
                        System.out.println("Taking Quiz ID: " + selectedQuiz.getQuizId());
                        int score = 0; // Keep track of the score
                        for (Question question : selectedQuiz.getQuestions()) {
                            question.display();
                            System.out.print("Enter your answer (true/false): ");
                            boolean answer = scanner.nextBoolean();
                            scanner.nextLine();
                            if (((TrueFalseQuestion) question).isCorrect(answer)) {
                                System.out.println("Correct!");
                                score += question.marks; // Add marks for correct answers
                            } else {
                                System.out.println("Incorrect.");
                            }
                        }
                        System.out.println("Quiz finished. Your score: " + score);

                    } else {
                        System.out.println("Invalid student or quiz selection.");
                    }
                    break;
              case 9:
    if (students.isEmpty() || courses.isEmpty()) {
        System.out.println("No students or courses available.");
        break;
    }

    System.out.println("Available Students:");
    for (int i = 0; i < students.size(); i++) {
        System.out.println((i + 1) + ". " + students.get(i).getName());
    }
    System.out.print("Select a student by number: ");
                  studentIndex = scanner.nextInt() - 1;
    scanner.nextLine();

    System.out.println("Available Courses:");
    for (int i = 0; i < courses.size(); i++) {
        System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
    }
    System.out.print("Select a course by number: ");
                  courseIndex = scanner.nextInt() - 1;
    scanner.nextLine();

    if (studentIndex >= 0 && studentIndex < students.size() && courseIndex >= 0 && courseIndex < courses.size()) {
        System.out.print("Enter Rating (0-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Comments: ");
        String comments = scanner.nextLine();

        Feedback feedback = new Feedback(1, students.get(studentIndex), courses.get(courseIndex), rating, comments);
        feedback.submitFeedback();

        try {
            DataHandler.saveFeedback(feedback, "feedback.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving feedback: " + e.getMessage());
        }
    } else {
        System.out.println("Invalid student or course selection.");
    }
    break;


               case 10:
    String feedbackFilePath = "feedback.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(feedbackFilePath))) {
        String line;
        System.out.println("Feedback from " + feedbackFilePath + ":");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("An error occurred while reading the feedback file: " + e.getMessage());
    }
    break;
    case 11:
        System.out.println(instructors);
    break;
    case 12:
        System.out.println(students);
    break;
    case 13:
        System.out.println("Exiting system. Goodbye!");
        scanner.close();
        return;

        default:
            System.out.println("Invalid option. Please try again.");
            }
        }
    }
}