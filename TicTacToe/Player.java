package TicTacToe;

import java.util.Scanner;

public class Player {
    public String name;
    public char symbol;
    public int row;
    public int column;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public void selectMove(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + " (" + symbol + "), enter your row (0, 1, or 2): ");
        row = scanner.nextInt();
        System.out.print(name + " (" + symbol + "), enter your column (0, 1, or 2): ");
        column = scanner.nextInt();
    }
    
}
