package controller;

import entity.*;

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
//        System.out.println();
//        game.eliminate(1,1);
//        System.out.println();
//        game.print();

        // Check for range booleans array
//        boolean[][] range = game.rangeOfEliminate(l);
//        for(int i=0; i<range.length; i++) {
//            for(int j=0; j<range[i].length; j++) {
//                System.out.print(range[i][j]+"  ");
//            }
//            System.out.println();
//        }

        // Check for fall
//        Block[][] blocks = game.getBoard().getBlocks();
//        blocks[3][5]=null;
//        blocks[2][5]=null;
//        game.print();
//        System.out.println();
//        game.fall(blocks);
//        game.print();
        game.eliminate(1,2);
        game.print();

    }
}
