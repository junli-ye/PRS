package entity;

/**
 * @name: AnimalBlock
 * @description:
 * @author: Junli YE
 */
public class AnimalBlock extends Block {
    private final Animal animal;

    @Override
    public boolean canSelect() {
        return false;
    }

    public AnimalBlock(Color color,Animal animal) {
       super(color);
       this.animal=animal;
    }

    @Override
    public String toString() {
        return "{"+this.animal.toString()+"}";
    }

    public Animal getAnimal(){
        return this.animal;
    }
}
