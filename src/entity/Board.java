package entity;

/**
 * @name: Board
 * @description:
 * @author: Junli YE
 */
public class Board {
    static final int WIDTH = 10;
    static final int HEIGHT = 10;

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

    protected Object[][] getBlocks(){
        return this.blocks;
    }

    /**
     * Print this board for internal checks
     */
    protected void print(){
        for(int i=0; i<WIDTH; i++){
            for(int j=0; j<HEIGHT; j++){
                System.out.print(blocks[i][j]+"   ");
            }
            System.out.println();
        }
    }
}