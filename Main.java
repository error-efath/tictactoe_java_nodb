import java.util.Scanner;

import javax.swing.SwingUtilities;

import TicTacToe.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        System.out.println("Select game mode:");
        System.out.println("1. Console Based");
        System.out.println("2. GUI Based");

        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (mode == 1) {
            do {
                System.out.print("Enter Player 1 name: ");
                String player1Name = scanner.nextLine();
                System.out.print("Enter Player 2 name: ");
                String player2Name = scanner.nextLine();

                Game game = new ConsoleBasedGame(player1Name, player2Name);
                game.play();

                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.nextLine();
            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("Thank you for playing!");
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new PlayerInputFrame();
                }
            });

        }
        scanner.close();
    }
}
