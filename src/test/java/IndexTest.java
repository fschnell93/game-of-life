import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IndexTest {
    @Test
    public void givenTwoEqualIndexesThenReturnTrue() {
        Index index1 = new Index(0, 0);
        Index index2 = new Index(0, 0);
        assertEquals(index1, index2);
    }

    @Test
    public void givenTwoDifferentIndexesThenReturnFalse() {
        Index index1 = new Index(0, 1);
        Index index2 = new Index(1, 0);
        assertNotEquals(index1, index2);
    }
}
