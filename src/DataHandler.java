import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataHandler {

    public static void saveStudent(Student student, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(student.getId() + "," +
                    student.getName() + "," +
                    student.getEmail() + "," +
                    student.getPassword() + System.lineSeparator());
        }
    }


    public static Student loadStudents(String filePath, ArrayList<Student> students) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return null;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    students.add(new Student(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]));
                }
            }
        }
        return null;
    }


    public static void saveCourse(Course course, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(course.getCourseID() + "," +
                    course.getCourseName() + "," +
                    course.getDescription() + "," +
                    course.getInstructor().getId() + System.lineSeparator());
        }
    }


    public static Course loadCourses(String filePath, ArrayList<Course> courses, ArrayList<Instructor> instructors) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return null;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Instructor instructor = findInstructorById(instructors, Integer.parseInt(parts[3]));
                    if (instructor != null) {
                        courses.add(new Course(parts[0], parts[1], parts[2], instructor));
                    }
                }
            }
        } return null;
    }


    public static void saveInstructor(Instructor instructor, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(instructor.getId() + "," +
                    instructor.getName() + "," +
                    instructor.getEmail() + "," +
                    instructor.getPassword() + System.lineSeparator());
        }
    }


    public static Instructor loadInstructors(String filePath, ArrayList<Instructor> instructors) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return null;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    instructors.add(new Instructor(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]));
                }
            }
        } return null;
    }

    public static Quiz loadQuiz(String filePath, ArrayList<Quiz> quizzes) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return null;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length==2){
                    quizzes.add(new Quiz(Integer.parseInt(parts[0]),Integer.parseInt(parts[1])));
                }
            }
        } return null;
    }

    public static Question loadQuestions(String filePath, ArrayList<Question> questions) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return null;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    questions.add(new Question(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])) {
                        @Override
                        public void display() {

                        }
                    });

                }
            }
        } return null;
    }

    private static Instructor findInstructorById(List<Instructor> instructors, int id) {
        for (Instructor instructor : instructors) {
            if (instructor.getId() == id) {
                return instructor;
            }
        }
        return null;
    }

    public static void saveQuestion(MultipleChoiceQuestion question, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(question.getQuestionId() + "," +
                    question.getText() + "," +
                    question.getMarks() + "," +
                    String.join(";", question.getOptions()) + "," +
                    question.getCorrectAnswer() + System.lineSeparator());
        }
    }


    public static ArrayList<MultipleChoiceQuestion> loadQuestions(String filePath) throws FileNotFoundException {
         File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        ArrayList<MultipleChoiceQuestion> questions = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",", -1);
                if (parts.length == 5) {
                    int questionId = Integer.parseInt(parts[0]);
                    String text = parts[1];
                    int marks = Integer.parseInt(parts[2]);

                   String[] options = parts[3].isEmpty() ? new String[0] : parts[3].split(";");


                    String correctAnswer = parts[4];

                    questions.add(new MultipleChoiceQuestion(questionId, text, marks, options, correctAnswer));
                } else {
                    System.err.println("Skipping invalid line: " + line);  // Error message
                }
            }
        }
        return questions;

    }


    public static void saveAssessment(Assessment assessment, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(assessment.getAssessmentID() + "," +
                    assessment.getCourse().getCourseID() + "," +
                    assessment.getStudent().getId() + "," +
                    assessment.getScore() + System.lineSeparator());
        }
    }

    public static Assessment loadAssessments(String filePath, ArrayList<Course> courses,ArrayList<Student> students) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) return null;
         try (Scanner scanner = new Scanner(file)) {
             if(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 4) {
                int assessmentID = Integer.parseInt(parts[0]);
                String courseID = parts[1];
                int studentId = Integer.parseInt(parts[2]);
                int score = Integer.parseInt(parts[3]);

                // find objects by id
                Course course = findCourseById(courseID,courses);
                Student student= findStudentById(studentId,students);
                return new Assessment(assessmentID, course,student,score);
            }
        }
        }
       return null;
    }
private static Course findCourseById(String courseId, ArrayList<Course> courses) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
    private static Student findStudentById(int studentId, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }
    public static void saveQuiz(Quiz quiz, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(quiz.getQuizId() + "," +
                    quiz.getCourseId() + System.lineSeparator()); // Only saving basic quiz info

        }

    }

public static void saveFeedback(Feedback feedback, String filePath) throws IOException {
    try (FileWriter writer = new FileWriter(filePath, true)) {
        writer.write("Feedback for student: " + feedback.getStudent().getName() + System.lineSeparator());
        writer.write("Course: " + feedback.getCourse().getCourseName() + System.lineSeparator());
        writer.write("Rating: " + feedback.getRating() + "/5" + System.lineSeparator());
        writer.write("Comments: " + feedback.getComments() + System.lineSeparator());
        writer.write(System.lineSeparator());
    }
}

        }
