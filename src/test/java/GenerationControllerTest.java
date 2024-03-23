import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GenerationControllerTest {
    private GenerationController controller;

    @BeforeEach
    void setUp() {
        this.controller = new GenerationController();
    }

    @Test
    public void givenLiveCellWithOneLiveNeighbourThenCellShouldDie() {
        assertFalse(controller.shouldLiveNextGeneration(1, true));
    }

    @Test
    public void givenLiveCellWithTwoLiveNeighboursThenCellShouldLive() {
        assertTrue(controller.shouldLiveNextGeneration(2, true));
    }

    @Test
    public void givenLiveCellWithThreeLiveNeighboursThenCellShouldLive() {
        assertTrue(controller.shouldLiveNextGeneration(3, true));
    }

    @Test
    public void givenLiveCellWithMoreThenThreeLiveNeighboursThenCellShouldDie() {
        assertFalse(controller.shouldLiveNextGeneration(4, true));
    }

    @Test
    public void givenDeadCellWithThreeLiveNeighboursThenCellShouldLive() {
        assertTrue(controller.shouldLiveNextGeneration(3, false));
    }

    @Test
    public void givenCellOnPositionZeroZeroThenReturnCorrectNeighbours() {
        List<Index> neighbours = controller.getNeighbours(3, 3, 0, 0);
        assertEquals(3, neighbours.size());
        assertTrue(neighbours.contains(new Index(0, 1)));
        assertTrue(neighbours.contains(new Index(1, 0)));
        assertTrue(neighbours.contains(new Index(1, 1)));
    }

    @Test
    public void givenCellOnPositionOneOneThenReturnCorrectNeighbours() {
        List<Index> neighbours = controller.getNeighbours(3, 3, 1, 1);
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
        List<Index> neighbours = controller.getNeighbours(3, 3, 0, 1);
        assertEquals(5, neighbours.size());
        assertTrue(neighbours.contains(new Index(0, 0)));
        assertTrue(neighbours.contains(new Index(0, 2)));
        assertTrue(neighbours.contains(new Index(1, 0)));
        assertTrue(neighbours.contains(new Index(1, 1)));
        assertTrue(neighbours.contains(new Index(1, 2)));
    }

    @Test
    public void givenGridThenCalculateNextGeneration() {
        GameOfLifeGrid spyGrid = Mockito.spy(new GameOfLifeGrid(2, 2, 1.0f));
        GenerationController spyController = Mockito.spy(new GenerationController());

        spyController.calculateNextGeneration(spyGrid);
        verify(spyController, times(1)).getNeighbours(2, 2, 0, 0);
        verify(spyController, times(1)).getNeighbours(2, 2, 0, 1);
        verify(spyController, times(1)).getNeighbours(2, 2, 1, 0);
        verify(spyController, times(1)).getNeighbours(2, 2, 1, 1);
        verify(spyController, times(4)).shouldLiveNextGeneration(3, true);
        verify(spyGrid, times(1)).setCellAlive(new Index(0, 0), true);
        verify(spyGrid, times(1)).setCellAlive(new Index(0, 1), true);
        verify(spyGrid, times(1)).setCellAlive(new Index(1, 0), true);
        verify(spyGrid, times(1)).setCellAlive(new Index(1, 1), true);
    }
}