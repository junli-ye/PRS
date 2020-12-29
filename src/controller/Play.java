package controller;

import entity.Board;

import java.util.Scanner;

/**
 * @name: Play
 * @description: Main class of this project
 * @author: Junli YE
 */
public class Play {
    public static void playInText() {
        Game game = new Game();
        System.out.println("Welcome to PRS Game, in this console you can play the game easily in text");
        System.out.println("Here we go:");
        game.print();
        Scanner sc = new Scanner(System.in);
        while(!game.isWin()) {
            System.out.println("Please enter the coordinate you want to click with ',' to separate");
            String l = sc.nextLine();
            String[] s = l.split(", ");
            game.eliminate(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
    }

    public static void main(String[] args) {
//        playInText();
        Game game = new Game();
        game.print();
        System.out.println();
        game.eliminate(1,1);
        System.out.println();
        game.print();

    }
}
