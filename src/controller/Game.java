package controller;

import entity.*;
import java.util.*;

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

    public void print() {
        this.board.print();
    }

    /**
     * Eliminate
     */
    public void eliminate(int x, int y) {
        boolean[][] range = rangeOfEliminate(new Location(x,y));
        Block[][] blocks = board.getBlocks();

        for(int i=0; i<blocks.length; i++) {
            for(int j=0; j<blocks[i].length; j++) {
                if(range[i][j]) {
                    blocks[i][j].eliminate();
                }
            }
        }

        fall(blocks);
    }

    /**
     * Range of elimination
     */
    private boolean[][] rangeOfEliminate(Location l) {
        boolean[][] range = new boolean[board.getWidth()][board.getHeight()];
        Block[][] blocks = board.getBlocks();
        NormalBlock b = (NormalBlock)blocks[l.getX()][l.getY()];

        for(int i=0; i<board.getWidth(); i++) {
            if (blocks[l.getX()][i].equals(b) && blocks[l.getX()][i].canSelect()) range[l.getX()][i] = true;
        }

        for(int j=0; j<board.getHeight(); j++) {
            if (blocks[j][l.getY()].equals(b) && blocks[j][l.getY()].canSelect()) range[j][l.getY()] = true;
        }

        return range;
    }

    /**
     * Cube sinking
     */
    private void fall(Block[][] blocks) {
        for(int i=blocks.length-2; i>=0; i--) {
            for(int j=0; j<blocks[i].length; j++) {
                int a=1;
                while(blocks[i+a][j] == null) {
                    blocks[i+a][j] = blocks[i][j];
                    blocks[i][j] = null;
                    a++;
                }
            }
        }
        this.board.setBlocks(blocks);
    }

    /**
     * Over?
     */
    public boolean isWin() {
        Block[][] blocks = board.getBlocks();
        for(int i=0; i<board.getWidth(); i++) {
            if (blocks[i][board.getWidth()-1] instanceof NormalBlock) return false;
        }
        return true;
    }
}
