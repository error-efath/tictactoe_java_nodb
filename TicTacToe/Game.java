package TicTacToe;

public abstract class Game {
    protected Player player1;
    protected Player player2;
    protected Board board;
    protected Player currentPlayer;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name, 'X');
        player2 = new Player(player2Name, 'O');
        board = new Board();
        currentPlayer = player1;
    }

    public abstract void play();

    protected void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
