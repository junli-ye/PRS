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
       super(animal);
    }

    @Override
    public String toString() {
        return "{"+super.toString()+"}";
    }
}
