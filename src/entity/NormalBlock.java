package entity;

/**
 * @name: NormalBlock
 * @description:
 * @author: Junli YE
 */
public class NormalBlock extends Block<Color> {
    public NormalBlock(Color c) {
        super(c);
    }

    @Override
    public boolean canSelect() {
        return true;
    }

    @Override
    public String toString() {
        return " "+super.toString()+" ";
    }

    @Override
    public void eliminate() {
        this.element=null;
    }
}
