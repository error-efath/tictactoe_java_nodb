package TicTacToe;

public class Board {
    char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean setMark(int row, int column, char symbol) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            System.out.println("Invalid position. Try again.");
            return false;
        }
        if (grid[row][column] != '.') {
            System.out.println("Cell already occupied. Try again.");
            return false;
        }
        grid[row][column] = symbol;
        return true;
    }

    public boolean checkWinner(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) ||
                    (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
                (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
    
}
