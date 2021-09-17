/**
 * creates the GUI for the 2048 game by using the
 * JAVA swing API
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GUIBoard extends JPanel implements KeyListener {
    
    private JFrame frame;

    private Board board;

    private int grids;

    private int boardSize;

    private int boardXY;

    // to make sure that enter is pressed first before playing the game
    private boolean first;

    /**
     * sets up the window/jframe for the 2048 game board along with the
     * the coordinates, size, and tile number
     * @param board
     */
    public GUIBoard(Board board) {
        first = false;
        frame = new JFrame("2048");
        this.board = board;
        this.grids = board.getGrids();
        this.boardSize = (50 * grids) + (4 * (grids + 1)); // 220
        this.boardXY = (500 - boardSize) / 2; // 140
        drawBoard();
    }

    /**
     * draws the 2048 game window
     */
    public void drawBoard() {
        ImageIcon icon = new ImageIcon("src/2048icon.png");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
        frame.setBackground(new Color(250, 248, 239));

        JLabel label = new JLabel();
        label.setText("2048");
        label.setForeground(new Color(119, 110, 124));
        label.setFont(new Font("Calibri", Font.BOLD, 30));
        label.setBounds(140, 0, 70, 50);
        frame.add(label);
        frame.add(this);
        frame.addKeyListener(this);
    }

    /**
     * paints the content of the 2048 game using graphics2D from the java swing API
     * the contents include the tiles, board, score, title, and instructions
     */
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(187, 173, 160));
        g2D.fillRoundRect(boardXY, boardXY, boardSize, boardSize, 10, 10);

        g2D.setColor(Color.BLACK);
        g2D.setFont(new Font("Calibri", Font.BOLD, 15));
        g2D.drawString("Press \"Enter\" to start the game!!!", 140, boardXY - 10);
      
        g2D.setColor(new Color(119, 110, 124));
        g2D.setFont(new Font("Calibri", Font.BOLD, 13));
        g2D.drawString("by: Grant Tannert", 140, 50);

        g2D.setColor(new Color(187, 173, 160));
        g2D.fillRoundRect(140 + 110 + 30, 5, 80, 50, 15, 15);

        g2D.setColor(Color.black);
        g2D.setFont(new Font("Calibri", Font.BOLD, 17));
        g2D.drawString("Score: ", 140 + 110 + 45, 20);

        g2D.setColor(Color.black);
        g2D.setFont(new Font("Calibri", Font.BOLD, 15));
        int scoreLength = String.valueOf(board.getScore()).length();
        g2D.drawString("" + board.getScore(), (140 + 110 + 30) + 40 - 4 * scoreLength, 40);

        g2D.setColor(new Color(119, 110, 124));
        g2D.setFont(new Font("Calibri", Font.BOLD, 13));
        g2D.drawString("Welcome to my Project demo for the", 140, 70);

        g2D.setColor(new Color(119, 110, 124));
        g2D.setFont(new Font("Calibri", Font.BOLD, 13));
        g2D.drawString("game 2048 :)", 140, 80);

        g2D.setColor(Color.black);
        g2D.setFont(new Font("Calibri", Font.BOLD, 14));
        g2D.drawString("Use WASD or the arrow keys to move", 140, boardXY + boardSize + 15);

        int y = boardXY + 4;

        for (int i = 0; i < board.getGrids(); i++) {
            int x = boardXY + 4;
            for (int j = 0; j < board.getGrids(); j++) {
                drawTiles(g2D, board.getBoard()[i][j], x, y);
                x += 54;
            }
            y += 54;
        }

        if (board.gameOver()) {
            g2D.setColor(new Color(187, 173, 160));
            g2D.fillRoundRect(boardXY, boardXY, boardSize, boardSize, 10, 10);

            g2D.setColor(Color.BLACK);
            g2D.drawString("Game Over", boardXY + (boardSize / 2) - 45, boardXY + (boardSize / 2));
        }

        if (board.win()) {
            g2D.setColor(new Color(187, 173, 160));
            g2D.fillRoundRect(boardXY, boardXY, boardSize, boardSize, 10, 10);

            g2D.setColor(Color.BLACK);
            g2D.drawString("You Win!", boardXY + (boardSize / 2) - 45, boardXY + (boardSize / 2));
        }
    }

    /**
     * draws the tiles for the 2048 game
     * @param g2D drawing tool
     * @param tile the current tile
     * @param x x coordinate
     * @param y y coordinate
     */
    private void drawTiles(Graphics2D g2D, Tile tile, int x, int y) {
        g2D.setColor(tile.getColor());
        g2D.fillRoundRect(x, y, 50, 50, 10, 10);

        if (tile.getValue() != 0) {
            g2D.setColor(tile.getColor());
            g2D.fillRoundRect(x, y, 50, 50, 10, 10);
            int length = String.valueOf(tile.getValue()).length();
            g2D.setColor(Color.black);
            float a = x + 25f - 5f * length; 
            float b = y + 30;
            g2D.setFont(new Font("default", Font.BOLD, 17));
            g2D.drawString("" + tile.getValue(), a, b);
        }
    }

    public void keyTyped(KeyEvent e) {}

    /**
     * to see which key has been pressed by the user
     */
    public void keyPressed(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
            board = new Board(grids);
            board.spawn();
            frame.repaint();
            first = true;
        }
        if (first) {
            if ( e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP ) {
                board.up();
                board.spawn();
                frame.repaint();
            }
            else if ( e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN ) {
                board.down();
                board.spawn();
                frame.repaint();
            }
            else if ( e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT ) {
                board.left();
                board.spawn();
                frame.repaint();
            }
            else if ( e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                board.right();
                board.spawn();
                frame.repaint();
            }
        }
    }

    public void keyReleased(KeyEvent e) {}
}
