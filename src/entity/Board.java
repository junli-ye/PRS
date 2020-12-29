package entity;

/**
 * @name: Board
 * @description:
 * @author: Junli YE
 */
public class Board {
    static final int WIDTH = 6;
    static final int HEIGHT = 6;

    private static BlockFactory factory = new BlockFactory();
    private Block[][] blocks;

    public Board() {
        this.blocks=new Block[WIDTH][HEIGHT];
        for(int j=0; j<HEIGHT; j++){
            blocks[0][j]=factory.createNewAnimalBlock();
            for(int i=1; i<WIDTH; i++){
                blocks[i][j]=factory.createNewNormalBlock();
            }
        }
    }

    public Block[][] getBlocks(){
        return this.blocks;
    }

    public void setBlocks(Block[][] blocks) { this.blocks=blocks; }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Print this board for internal checks
     * Should be deleted
     */
    public void print(){
        for(int i=0; i<WIDTH; i++){
            for(int j=0; j<HEIGHT; j++){
                System.out.print(blocks[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
