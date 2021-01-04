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
        System.out.println("Hello! Welcome to PRS game, I hope you can have a nice day!");
        System.out.println("Bonjour ! Bienvenue à PRS Games et je vous souhaite une excellente journée !");
        System.out.println("您好！欢迎来到PRS游戏，希望您可以度过愉快的一天！");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Please enter 1 for English and press enter；\n" +
                "Pour le français, tapez 2 et appuyez sur enter；\n" +
                "中文请输入3并按回车");
        Scanner sc = new Scanner(System.in);
        int lang = sc.nextInt();
        int mode;
        if (lang == 2) {
            System.out.println("Veuillez entrer votre prénom:");
            String name = sc.nextLine();
            System.out.println("Bonjour！ " + name + " .\n Veuillez entrer dans le mode de jeu que vous souhaitez et appuyer sur la touche entrée：\n" +
                    "[1] Jeux en texte \n" +
                    "[2] Jeux avec interface");
            mode = sc.nextInt();
        } else if (lang == 3) {
            System.out.println("请输入您的名字：");
            String name = sc.next();
            System.out.println("哈啰！ " + name + " .\n 请选择您要进入的游戏模式，然后按Enter：\n" +
                    "[1] 文字版 \n" +
                    "[2] 图形版");
            mode = sc.nextInt();
        } else {
            System.out.println("Please enter your name：");
            String name = sc.nextLine();
            System.out.println("Hello！ " + name + " .\n Please enter the game mode you want to enter and press enter：\n" +
                    "[1] Text Play \n" +
                    "[2] Interface Play");
            mode = sc.nextInt();
        }

        if(mode == 1) playInText();
        else playInWindow();
    }
}


