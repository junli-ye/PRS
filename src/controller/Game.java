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
     */
    public Board getBoard() {
        return board;
    }

    public void print() {
        this.board.print();
    }

    /**
     * Eliminate
     * The steps to be completed for the elimination action are:
     * 1) Eliminate the selected position and the square with its attached position that meets the conditions
     * 2) Complete a fall action to make the square fall
     */
    public void eliminate(int x, int y) {
        boolean[][] range = rangeOfEliminate(new Location(x,y));
        Block<?>[][] blocks = board.getBlocks();

        try{
            for(int i=0; i<blocks.length; i++) {
                for(int j=0; j<blocks[i].length; j++) {
                    if(range[i][j]) {
                        blocks[i][j].eliminate();
                    }
                }
            }
        }catch (Exception e) {
            System.out.println("Error: The square you have selected cannot be eliminated, or there are no squares in the coordinates");
        }

        fall(blocks);
    }

    /**
     * Range of elimination
     */
    public boolean[][] rangeOfEliminate(Location l) {
        boolean[][] range = new boolean[board.getWidth()][board.getHeight()];
        Block<?>[][] blocks = board.getBlocks();
        NormalBlock b = (NormalBlock)blocks[l.getX()][l.getY()];

        // Check whether the selected block itself can be eliminated: whether there are the same adjacent blocks
        if (l.getX() == 0) {
            // the special case of the uppermost boundary
            if (l.getY() == 0) {
                // Special algorithm for the upper left corner position
                if (blocks[0][1].equals(b) || blocks[1][0].equals(b)) range[l.getX()][l.getY()] = true;
            }else if (l.getY() == board.getWidth()-1) {
                // Special algorithm for the upper right corner
                if (blocks[0][board.getWidth()-2].equals(b) || blocks[1][board.getWidth()-1].equals(b)) range[l.getX()][l.getY()] = true;
            }else {
                if (blocks[0][l.getY()-1].equals(b) || blocks[0][l.getY()+1].equals(b) || blocks[1][l.getY()].equals(b)) range[l.getX()][l.getY()] = true;
            }
        }else if (l.getX() == board.getHeight()-1) {
            // Special case of the lower boundary
            if (l.getY() == 0) {
                // Special algorithm for the lower left corner
                if (blocks[board.getHeight()-1][1].equals(b) || blocks[board.getHeight()-2][0].equals(b)) range[l.getX()][l.getY()] = true;
            }else if (l.getY() == board.getWidth()-1) {
                // Special algorithm for the lower right corner
                if (blocks[board.getHeight()-1][board.getWidth()-2].equals(b) || blocks[board.getHeight()-2][board.getWidth()-1].equals(b)) range[l.getX()][l.getY()] = true;
            }else {
                if (blocks[board.getHeight()-1][l.getY()-1].equals(b) || blocks[board.getHeight()-1][l.getY()+1].equals(b)
                        || blocks[board.getHeight()-2][l.getY()].equals(b)) range[l.getX()][l.getY()] = true;
            }
        }else if (l.getY() == 0 || l.getY() == board.getWidth()-1) {
            // Special cases of the left and right borders (where the corner positions have been excluded)
            if (blocks[l.getX()+1][l.getY()].equals(b) || blocks[l.getX()-1][l.getY()].equals(b)) range[l.getX()][l.getY()] = true;
        }else {
            // Ordinary algorithm
            if(blocks[l.getX()+1][l.getY()].equals(b) || blocks[l.getX()-1][l.getY()].equals(b)
                    || blocks[l.getX()][l.getY()+1].equals(b) || blocks[l.getX()][l.getY()-1].equals(b))
                range[l.getX()][l.getY()] = true;
        }

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

        // If an animal reach the land
        for(int x=0; x<board.getWidth(); x++) {
            if (blocks[5][x] instanceof AnimalBlock) range[5][x] = true;
        }

        return range;
    }

    /**
     * Block sinking
     */
    public void fall(Block<?>[][] blocks) {
        // Because all the squares are sinking in their own column, they are divided into different columns to deal with the problem
        for(int j=0; j<board.getWidth(); j++) {

            // Step 1: Take out each column of squares to generate a new array tmp for operation
            Block<?>[] tmp = new Block[board.getHeight()];
            for(int k=0; k<tmp.length; k++) {
                tmp[k] = blocks[k][j];
            }

            // Step 2: Call the delete Null Block function to process tmp, and get the reordered array deleted
            Block<?>[] deleted = deleteNullBlock(tmp);

            // Part 3: Put each element in the deleted array back into blocks
            for(int i=0; i<deleted.length; i++) {
                blocks[i][j]=deleted[deleted.length-1-i];
            }
        }
        // update Board
        this.board.setBlocks(blocks);
    }

    private Block<?>[] deleteNullBlock(Block<?>[] arr) {
        // step1: Define a list list, and loop assignment
        ArrayList<Block<?>> bList = new ArrayList<>();
        for (int i = arr.length-1; i >= 0; i--) {
            bList.add(arr[i]);
        }

        // step2: Delete all empty values ​​in the list
        bList.removeIf(b -> b == null || b.getElement() == null);


        if(bList.size() < arr.length) {
            for(int j=bList.size(); j<arr.length; j++){
                bList.add(new NormalBlock(null));
            }
        }

        // step3: Convert the list of lists to a newly defined intermediate array and assign values ​​to it

        return bList.toArray(new Block[0]);
    }

    /**
     * Over?
     */
    public boolean isWin() {
        Block<?>[][] blocks = board.getBlocks();
        for(int i=0; i<board.getWidth(); i++) {
            if (blocks[i][board.getWidth()-1] instanceof NormalBlock) return false;
        }
        return true;
    }

    public void setSize(int x) {
        this.board.setHEIGHT(x);
        this.board.setWIDTH(x);
    }
}
