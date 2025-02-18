// TicTacToe/PlayerInputFrame.java
package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInputFrame {
    private JFrame frame;
    private JTextField player1Field;
    private JTextField player2Field;

    public PlayerInputFrame() {
        setupGUI();
    }

    private void setupGUI() {
        // Create the main frame
        frame = new JFrame("Player Names");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Main panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Input panel with GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Adding components to input panel
        inputPanel.add(new JLabel("Player 1 Name:", JLabel.RIGHT));
        player1Field = new JTextField(15);
        inputPanel.add(player1Field);

        inputPanel.add(new JLabel("Player 2 Name:", JLabel.RIGHT));
        player2Field = new JTextField(15);
        inputPanel.add(player2Field);

        // Creating the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        buttonPanel.add(startButton);

        // Adding panels to frame
        mainPanel.add(inputPanel);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Configuring and showing frame
        frame.pack();
        frame.setSize(350, 180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void startGame() {
        String player1Name = player1Field.getText().trim();
        String player2Name = player2Field.getText().trim();

        if (player1Name.isEmpty() || player2Name.isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Please enter names for both players",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        frame.dispose();
        Game game = new GUIBasedGame(player1Name, player2Name);
        game.play();
    }
}