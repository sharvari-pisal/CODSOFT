import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        playNumbergame();
    }

    private static void playNumbergame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsWon = 0;

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {
            
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            
            int attempts = 0;

            System.out.println("\nGuess the number between " + minRange + " and " + maxRange + "!");

            while (attempts < maxAttempts) {
                
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly!");
                    roundsWon++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attempts++;
            }

            totalAttempts += attempts;

            System.out.print("Do you want to play again? (Yes/No): ");
            playAgain = scanner.next();
        }

        System.out.println("\nGame over! \nYour total score is " + roundsWon +
                " rounds won with an average of " + (double) totalAttempts / roundsWon + " attempts per round.");

        
        scanner.close();
    }
}

