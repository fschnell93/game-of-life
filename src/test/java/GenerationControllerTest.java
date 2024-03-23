import org.junit.jupiter.api.Test;

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
}