import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            char playAgain;
            int totalAttempts = 0;
            int totalGames = 0;

            do {
                int secretNumber = random.nextInt(100) + 1;
                int attemptsAllowed = 5;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("Guess the number between 1 and 100.");

                while (attempts < attemptsAllowed) {
                    System.out.print("Enter your guess: ");
                    int guess = sc.nextInt();
                    attempts++;
                    totalAttempts++;

                    if (guess == secretNumber) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        break;
                    } else if (guess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you didn't guess the number. The correct number was " + secretNumber + ".");
                }

                totalGames++;

                System.out.print("Do you want to play again? (y/n): ");
                playAgain = sc.next().charAt(0);
            } while (playAgain == 'y' || playAgain == 'Y');

            int score = totalGames - totalAttempts;
            System.out.println("Total games played: " + totalGames);
            System.out.println("Total attempts made: " + totalAttempts);
            System.out.println("Your score: " + score);
        }

        System.out.println("Thanks for playing!");
    } 
}
