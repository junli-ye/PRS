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
    public boolean[][] rangeOfEliminate(Location l) {
        boolean[][] range = new boolean[board.getWidth()][board.getHeight()];
        Block[][] blocks = board.getBlocks();
        NormalBlock b = (NormalBlock)blocks[l.getX()][l.getY()];

        // self
        if(blocks[l.getX()+1][l.getY()].equals(b) || blocks[l.getX()-1][l.getY()].equals(b)
                || blocks[l.getX()][l.getY()+1].equals(b) || blocks[l.getX()][l.getY()-1].equals(b))
            range[l.getX()][l.getY()] = true;

        // right
        for(int r=l.getY()+1; r<board.getWidth(); r++) {
            if (blocks[l.getX()][r].equals(b) && blocks[l.getX()][r].canSelect() && blocks[l.getX()][r-1].equals(b)) range[l.getX()][r] = true;
        }

        // left
        for(int f=l.getY()-1; f>=0; f--) {
            if (blocks[l.getX()][f].equals(b) && blocks[l.getX()][f].canSelect() && blocks[l.getX()][f+1].equals(b)) range[l.getX()][f] = true;
        }

        // verticalUp
        for(int u=l.getX()-1 ; u>=0; u--) {
            if (blocks[u][l.getY()].equals(b) && blocks[u][l.getY()].canSelect() && blocks[u+1][l.getY()].equals(b)) range[u][l.getY()] = true;
        }

        // verticalDown
        for(int d=l.getX()+1 ; d<board.getHeight(); d++) {
            if (blocks[d][l.getY()].equals(b) && blocks[d][l.getY()].canSelect() && blocks[d-1][l.getY()].equals(b)) range[d][l.getY()] = true;
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
