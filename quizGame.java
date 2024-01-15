import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

class QuizGame {
    private ArrayList<Question> questions;
    private int score;

    public QuizGame() {
        this.questions = new ArrayList<>();
        this.score = 0;

        // Add some sample questions
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "London"}, 1));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Mars", "Venus", "Jupiter"}, 0));
        questions.add(new Question("What is the largest mammal?", new String[]{"Elephant", "Blue Whale", "Giraffe"}, 1));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Quiz Game!");
        System.out.println("Answer the following questions:");

        for (Question question : questions) {
            displayQuestion(question);
            int userAnswer = getUserAnswer(scanner);
            checkAnswer(question, userAnswer);
        }

        displayScore();
    }

    private void displayQuestion(Question question) {
        System.out.println("\n" + question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private int getUserAnswer(Scanner scanner) {
        System.out.print("Your answer (enter the option number): ");
        return scanner.nextInt() - 1;
    }

    private void checkAnswer(Question question, int userAnswer) {
        if (question.isCorrect(userAnswer)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + (question.correctOptionIndex + 1));
        }
    }

    private void displayScore() {
        System.out.println("\nQuiz completed! Your final score: " + score + " out of " + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        quizGame.startQuiz();
    }
}
