import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenerationControllerTest {

    @Test
    public void givenLiveCellWithOneLiveNeighbourThenCellShouldDie() {
        assertFalse(GenerationController.shouldLiveNextGeneration(1, true));
    }

    @Test
    public void givenLiveCellWithTwoLiveNeighboursThenCellShouldLive() {
        assertTrue(GenerationController.shouldLiveNextGeneration(2, true));
    }

    @Test
    public void givenLiveCellWithThreeLiveNeighboursThenCellShouldLive() {
        assertTrue(GenerationController.shouldLiveNextGeneration(3, true));
    }

    @Test
    public void givenLiveCellWithMoreThenThreeLiveNeighboursThenCellShouldDie() {
        assertFalse(GenerationController.shouldLiveNextGeneration(4, true));
    }

    @Test
    public void givenDeadCellWithThreeLiveNeighboursThenCellShouldLive() {
        assertTrue(GenerationController.shouldLiveNextGeneration(3, false));
    }

    @Test
    public void givenCellOnPositionZeroZeroThenReturnCorrectNeighbours() {
        List<Index> neighbours = GenerationController.getNeighbours(3, 3, 0, 0);
        assertEquals(3, neighbours.size());
        assertTrue(neighbours.contains(new Index(0, 1)));
        assertTrue(neighbours.contains(new Index(1, 0)));
        assertTrue(neighbours.contains(new Index(1, 1)));
    }

    @Test
    public void givenCellOnPositionOneOneThenReturnCorrectNeighbours() {
        List<Index> neighbours = GenerationController.getNeighbours(3, 3, 1, 1);
        assertEquals(8, neighbours.size());
        assertTrue(neighbours.contains(new Index(0, 0)));
        assertTrue(neighbours.contains(new Index(0, 1)));
        assertTrue(neighbours.contains(new Index(0, 2)));
        assertTrue(neighbours.contains(new Index(1, 0)));
        assertTrue(neighbours.contains(new Index(1, 2)));
        assertTrue(neighbours.contains(new Index(2, 0)));
        assertTrue(neighbours.contains(new Index(2, 1)));
        assertTrue(neighbours.contains(new Index(2, 2)));
    }

    @Test
    public void givenCellOnPositionZeroOneThenReturnCorrectNeighbours() {
        List<Index> neighbours = GenerationController.getNeighbours(3, 3, 0, 1);
        assertEquals(5, neighbours.size());
        assertTrue(neighbours.contains(new Index(0, 0)));
        assertTrue(neighbours.contains(new Index(0, 2)));
        assertTrue(neighbours.contains(new Index(1, 0)));
        assertTrue(neighbours.contains(new Index(1, 1)));
        assertTrue(neighbours.contains(new Index(1, 2)));
    }
}