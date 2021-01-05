package controller;

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
            System.out.println("First please enter the value of x and then press the enter button. \n" +
                    "If you want to end the game, please enter 999 twice");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 999 && y == 999) {
                System.out.println("****************** \n" +
                                   "*****GOOD BYE***** \n" +
                                "******************");
                System.exit(0);
            }
            System.out.println("The coordinate where you want to eliminate is: "+x+","+y);
            try{
                game.eliminate(x,y);
            }catch (Exception e) {
                System.out.println("Oooops! Something is wrong. Try again:)");
            }finally {
                game.print();
            }
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
            System.out.print("Veuillez entrer votre prénom:");
            String name = sc.next();
            System.out.println("Bonjour！ " + name + " .\n Veuillez entrer dans le mode de jeu que vous souhaitez et appuyer sur la touche entrée：\n" +
                    "[1] Jeux en texte \n" +
                    "[2] Jeux avec interface");
            mode = sc.nextInt();
        } else if (lang == 3) {
            System.out.print("请输入您的名字：");
            String name = sc.next();
            System.out.println("哈啰！ " + name + " .\n 请选择您要进入的游戏模式，然后按Enter：\n" +
                    "[1] 文字版 \n" +
                    "[2] 图形版");
            mode = sc.nextInt();
        } else {
            System.out.print("Please enter your name：");
            String name = sc.next();
            System.out.println("Hello！ " + name + " .\n Please enter the game mode you want to enter and press enter：\n" +
                    "[1] Text Play \n" +
                    "[2] Interface Play");
            mode = sc.nextInt();
        }

        if(mode == 1) playInText();
        else playInWindow();
    }
}


