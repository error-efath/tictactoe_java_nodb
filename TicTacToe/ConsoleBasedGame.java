// TicTacToe/ConsoleBasedGame.java
package TicTacToe;

public class ConsoleBasedGame extends Game {
    public ConsoleBasedGame(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    @Override
    public void play() {
        System.out.println("Welcome to Tic-Tac-Toe Console Game");
        int move = 0;

        while (move < 9) {
            board.display();
            currentPlayer.selectMove();
            boolean isValid = board.setMark(currentPlayer.row, currentPlayer.column, currentPlayer.symbol);

            if (!isValid) {
                continue;
            }

            if (board.checkWinner(currentPlayer.symbol)) {
                board.display();
                System.out.println(currentPlayer.name + " has won!");
                return;
            }

            if (board.isDraw()) {
                board.display();
                System.out.println("It's a draw!");
                return;
            }

            move++;
            switchPlayer();
        }
    }
}