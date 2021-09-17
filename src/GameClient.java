/**
 * Grant Tannert
 * 09/16/21
 * 2048 game project
 * 
 * Game client for the 2048 game as it will introduce the game to the user
 * and then will start the game.
 */

import java.util.Scanner;

public class GameClient {
    /**
     * Throws IllegalArgumentException when grids > 5 or grids < 2
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        intro();
        System.out.print("Choose the size of your board/tiles (2-5): ");
        int gridVal = sc.nextInt();
        sc.close();
        if (gridVal < 2 || gridVal > 5) {
            throw new IllegalArgumentException("value out of bounds");
        }
        new GUIBoard(new Board(gridVal));
    }

    /**
     * intro to game
     */
    public static void intro() {
        System.out.println("Welcome to my own Project demo for the 2048 game, I made ");
        System.out.println("this game as a beginner project to develop my programming skills.");
        System.out.println("In this version of 2048, you are able to resize the board however");
        System.out.println("you like it, I hope you enjoy it!!!");
        System.out.println();
    }
}
