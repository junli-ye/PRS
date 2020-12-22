package entity;

/**
 * @name: AnimalBlock
 * @description:
 * @author: Junli YE
 */
public class AnimalBlock extends Block<Animal> {

    @Override
    public boolean canSelect() {
        return false;
    }

    public AnimalBlock(Animal animal) {
        element=animal;
    }

    @Override
    public String toString() {
        return "{"+this.element.toString()+"}";
    }
}
