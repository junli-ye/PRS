package entity;

import java.util.Objects;

/**
 * @name: Block
 * @description:
 * @author: Junli YE
 */
abstract class Block<T> {
    protected T element;

    T getElement() {
        return this.element;
    }

    void T(T t) {
        this.element=t;
    }

    /**
     * Only colour blocks can be eliminated, not animal blocks
     * @return a boolean value represents is a normal bock or not
     */
    public abstract boolean canSelect();

    /**
     * Main functions of this program
     * This method is activated when the user selects a square, causing the square to be eliminated
     */
    public void select(){

    }

    @Override
    public String toString() {
        return this.element.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        Block blk = (Block)obj;
        return this.element == blk.element;
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
