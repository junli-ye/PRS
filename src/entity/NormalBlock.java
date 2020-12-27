package entity;

/**
 * @name: NormalBlock
 * @description:
 * @author: Junli YE
 */
public class NormalBlock extends Block<Color> {
    @Override
    public boolean canSelect() {
        return true;
    }

    public NormalBlock (Color color){
        this.element=color;
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
