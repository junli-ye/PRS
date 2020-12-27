package entity;

import java.util.Objects;

/**
 * @name: Block
 * @description:
 * @author: Junli YE
 */
public abstract class Block {
    protected Color color;

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color=c;
    }

    public Block(Color c) {
        this.color=c;
    }

    /**
     * Only colour blocks can be eliminated, not animal blocks
     * @return a boolean value represents is a normal bock or not
     */
    public abstract boolean canSelect();

    /**
     * This method is activated when the user selects a square, causing the square to be eliminated
     */
    public void eliminate() {
    }

    @Override
    public String toString() {
        return this.color.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        Block blk = (Block)obj;
        return this.color == blk.color;
    }
}
