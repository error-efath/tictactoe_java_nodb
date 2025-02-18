// TicTacToe/GUIBasedGame.java
package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBasedGame extends Game {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel statusLabel;

    public GUIBasedGame(String player1Name, String player2Name) {
        super(player1Name, player2Name);
        setupGUI();
    }

    private void setupGUI() {
        // Create the main frame
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Status label at the top
        statusLabel = new JLabel(currentPlayer.name + "'s turn (" + currentPlayer.symbol + ")");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPanel statusPanel = new JPanel(new GridLayout(1, 1));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statusPanel.add(statusLabel);
        frame.add(statusPanel, BorderLayout.NORTH);

        // Creating game board panel with buttons
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(".");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setPreferredSize(new Dimension(80, 80));
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleMove(row, col);
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.setSize(350, 400);
        frame.setLocationRelativeTo(null);
    }

    private void handleMove(int row, int col) {
        if (buttons[row][col].getText().equals(".")) {
            // Update button display
            buttons[row][col].setText(String.valueOf(currentPlayer.symbol));

            // Update game state
            board.setMark(row, col, currentPlayer.symbol);

            // Check for winner
            if (board.checkWinner(currentPlayer.symbol)) {
                showResultFrame(currentPlayer.name + " has won!");
                disableButtons();
                return;
            }

            // Draw checking
            if (board.isDraw()) {
                showResultFrame("It's a draw!");
                disableButtons();
                return;
            }

            // Switching players and update status
            switchPlayer();
            statusLabel.setText(currentPlayer.name + "'s turn (" + currentPlayer.symbol + ")");
        }
    }

    private void showResultFrame(String message) {
        JFrame resultFrame = new JFrame("Game Over");
        resultFrame.setLayout(new BorderLayout());

        // Message panel setup
        JPanel messagePanel = new JPanel(new GridLayout(1, 1));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel resultLabel = new JLabel(message, JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messagePanel.add(resultLabel);

        // Button panel Setup
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        JButton newGameButton = new JButton("New Game");
        JButton exitButton = new JButton("Exit");

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                resultFrame.dispose();
                new PlayerInputFrame();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                resultFrame.dispose();
                showThankYouFrame();
            }
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(exitButton);

        resultFrame.add(messagePanel, BorderLayout.CENTER);
        resultFrame.add(buttonPanel, BorderLayout.SOUTH);

        resultFrame.setSize(300, 150);
        resultFrame.setLocationRelativeTo(frame);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setVisible(true);
    }

    private void showThankYouFrame() {
        JFrame thankYouFrame = new JFrame("Thank You");
        thankYouFrame.setLayout(new BorderLayout());

        // Setup message panel
        JPanel messagePanel = new JPanel(new GridLayout(1, 1));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel thankYouLabel = new JLabel("Thank you for playing!", JLabel.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messagePanel.add(thankYouLabel);

        // Setup button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 100));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thankYouFrame.dispose();
                System.exit(0);
            }
        });
        buttonPanel.add(closeButton);

        thankYouFrame.add(messagePanel, BorderLayout.CENTER);
        thankYouFrame.add(buttonPanel, BorderLayout.SOUTH);

        thankYouFrame.setSize(300, 150);
        thankYouFrame.setLocationRelativeTo(null);
        thankYouFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thankYouFrame.setVisible(true);
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    @Override
    public void play() {
        frame.setVisible(true);
    }
}