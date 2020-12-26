package controller;

import entity.*;

/**
 * @name: Game
 * @description:
 * @author: Junli YE
 */
public class Game {
    private Board board;

    public Game() {
        this.board = new Board();
    }

    /**
     * Print this board for internal checks
     * Should be deleted
     */
    public void print() {
        this.board.print();
    }

    /**
     * Swap cubes
     */
    private void swithTwoBlocks(NormalBlock b1, NormalBlock b2) {
        Color tmp = b1.getElement();
        b1.setElement(b2.getElement());
        b2.setElement(tmp);
    }

    /**
     * Eliminate
     */
    private void eliminate() {
//        ... TODO with hashmap
    }

    /**
     * Cube sinking
     */
    private void fall( ) {
//        ... TODO
    }

}
