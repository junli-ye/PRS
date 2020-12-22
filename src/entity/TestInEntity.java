package entity;

/**
 * @name: TestInEntity
 * @description:
 * @author: Junli YE
 */
public class TestInEntity {
    public static void main(String[] args){
        BlockFactory factory = new BlockFactory();
//        NormalBlock nb = new NormalBlock(Color.BLUE);
//        AnimalBlock ab = new AnimalBlock(Animal.CHICKEN);
//        System.out.println(factory.createNewNormalBlock());
//        System.out.println(factory.createNewAnimalBlock());
        Board b= new Board();
        b.print();
    }
}
