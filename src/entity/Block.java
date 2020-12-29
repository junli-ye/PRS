package entity;

import java.util.Objects;

/**
 * @name: Block
 * @description:
 * @author: Junli YE
 */
public abstract class Block<T> {
    protected T element;

    public T getElement() {
        return this.element;
    }

    public void setElement(T t) {
        this.element = t;
    }

    public Block(T t) {
        this.element = t;
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
        if(this.element != null) return this.element.toString();
        else return " ";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        Block blk = (Block)obj;
        return this.element == blk.element;
    }
}
