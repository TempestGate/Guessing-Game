import java.util.Random;
import java.util.Scanner;

public class GuesssingGame {
    public static void main(String[] args) {
        int maxNumber = selectGameMode();
        introduceGame(maxNumber);

        int totalGames = 0;
        int totalGuesses = 0;
        int bestGame = Integer.MAX_VALUE;

        boolean playAgain = true;
        while (playAgain) {
            int numGuesses = playGame(maxNumber);
            totalGames++;
            totalGuesses += numGuesses;
            if (numGuesses < bestGame) {
                bestGame = numGuesses;
            }
            playAgain = playAgain();
        }

        reportResults(totalGames, totalGuesses, bestGame);
    }

    public static int selectGameMode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Select a game mode:");
        System.out.println("1. Easy (1 to 50)");
        System.out.println("2. Normal (1 to 100)");
        System.out.println("3. Hard (1 to 200)");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        int maxNumber;
        switch (choice) {
            case 1:
                maxNumber = 50;
                break;
            case 2:
                maxNumber = 100;
                break;
            case 3:
                maxNumber = 200;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Normal mode.");
                maxNumber = 100;
        }

        return maxNumber;
    }

    public static void introduceGame(int maxNumber) {
        System.out.println("I'm thinking of a number between 1 and " + maxNumber + ".");
        System.out.println("Try to guess it!");
    }

    public static int playGame(int maxNumber) {
        Random random = new Random();
        int targetNumber = random.nextInt(maxNumber) + 1;
        int numGuesses = 0;

        Scanner scanner = new Scanner(System.in);

        boolean correctGuess = false;
        while (!correctGuess) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numGuesses++;

            if (userGuess < targetNumber) {
                System.out.println("Higher!");
            } else if (userGuess > targetNumber) {
                System.out.println("Lower!");
            } else {
                System.out.println("Congratulations! You guessed it in " + numGuesses + " attempts.");
                correctGuess = true;
            }
        }

        return numGuesses;
    }

    public static boolean playAgain() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to play again? (y/n): ");
        String playAgainInput = scanner.next();

        return playAgainInput.equalsIgnoreCase("y");
    }

    public static void reportResults(int totalGames, int totalGuesses, int bestGame) {
        double averageGuesses = (double) totalGuesses / totalGames;

        System.out.println("Overall results:");
        System.out.println("  total games   = " + totalGames);
        System.out.println("  total guesses = " + totalGuesses);
        System.out.println("  guesses/game  = " + averageGuesses);
        System.out.println("  best game     = " + bestGame);
    }
}
