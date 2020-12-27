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
     * Getter
     * @return
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Print this board for internal checks
     * Should be deleted
     */
    public void print() {
        this.board.print();
    }

    /**
     * Eliminate
     */
    private void eliminate(boolean[][] range) {
        Object[][] blocks = this.board.getBlocks();
        // to insert Exception about size confirmation

        for(int i=0; i<blocks.length; i++) {
            for(int j=0; j<blocks[i].length; j++) {
                if(range[i][j]) {
                    // How to call Eliminate???
                }
            }
        }
    }

    /**
     * Eliminate 范围
     */
    private boolean[][] rangeOfEliminate(Location l) {
        boolean[][] range = new boolean[board.getWidth()][board.getHeight()];
        NormalBlock b = (NormalBlock) board.getBlocks()[l.getX()][l.getY()];

        for(int i=0; i<board.getWidth(); i++) {
            if (board.getBlocks()[l.getX()][i].equals(b)) range[l.getX()][i] = true;
        }

        for(int j=0; j<board.getHeight(); j++) {
            if (board.getBlocks()[j][l.getY()].equals(b)) range[j][l.getY()] = true;
        }

        return range;
    }

    /**
     * Cube sinking
     */
    private void fall( ) {
//        ... TODO
    }

    /**
     * Over?
     */
    public boolean isWin() {
        return true;
    }

}
