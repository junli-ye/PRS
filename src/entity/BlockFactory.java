package entity;

import java.util.Random;

/**
 * @name: NormalBlockFactory
 * @description: This factory generates randomly normal blocks
 * @author: Junli YE
 */
public class BlockFactory {
    private Random rd = new Random();

    public NormalBlock createNewNormalBlock() {
        Color[] c = Color.values();
        int x = rd.nextInt(c.length);
        return new NormalBlock(c[x]);
    }

    public AnimalBlock createNewAnimalBlock() {
        Animal[] a = Animal.values();
        int x = rd.nextInt(a.length);
        return new AnimalBlock(a[x]);
    }
}
