package controller;

import entity.*;
import view.View;

import java.awt.*;
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
        while(!game.isWin()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the coordinate you want to click.");
            System.out.println("First please enter the value of x and then press the enter button.");
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("The coordinate where you want to eliminate is: "+x+","+y);
            game.eliminate(x,y);
            game.print();
        }
    }

    public static void playInWindow() {
        Game game = new Game();
        View view = new View(game);
        // Thread-Safe
        EventQueue.invokeLater(() -> {
            try{
                view.setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        playInWindow();
//        playInText();
//        Game game = new Game();
//        game.print();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the coordinate you want to click");
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        System.out.println("The coordinate where you want to eliminate is: "+x+","+y);
//        game.eliminate(x,y);
//        game.print();

//        System.out.println();
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
//        game.eliminate(1,2);
//        game.print();

        // Test for playInWindow
//        playInWindow();
    }
}


