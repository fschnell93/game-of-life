package se.schnell.solutions.gameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndexTest {
    @Test
    public void givenTwoEqualIndexesThenReturnTrue() {
        Index index1 = new Index(0, 0);
        Index index2 = new Index(0, 0);
        Assertions.assertEquals(index1, index2);
    }

    @Test
    public void givenTwoDifferentIndexesThenReturnFalse() {
        Index index1 = new Index(0, 1);
        Index index2 = new Index(1, 0);
        Assertions.assertNotEquals(index1, index2);
    }
}
