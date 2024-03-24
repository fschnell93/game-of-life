package se.schnell.solutions.gameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameOfLifeControllerTest {
    private GameOfLifeController controller;

    @BeforeEach
    void setUp() {
        this.controller = new GameOfLifeController(new GameOfLifeGrid(3, 3, 0.5f));
    }

    @Test
    public void givenLiveCellWithOneLiveNeighbourThenCellShouldDie() {
        Assertions.assertFalse(controller.willSurviveToNextGeneration(1, true));
    }

    @Test
    public void givenLiveCellWithTwoLiveNeighboursThenCellShouldLive() {
        Assertions.assertTrue(controller.willSurviveToNextGeneration(2, true));
    }

    @Test
    public void givenLiveCellWithThreeLiveNeighboursThenCellShouldLive() {
        Assertions.assertTrue(controller.willSurviveToNextGeneration(3, true));
    }

    @Test
    public void givenLiveCellWithMoreThenThreeLiveNeighboursThenCellShouldDie() {
        Assertions.assertFalse(controller.willSurviveToNextGeneration(4, true));
    }

    @Test
    public void givenDeadCellWithThreeLiveNeighboursThenCellShouldLive() {
        Assertions.assertTrue(controller.willSurviveToNextGeneration(3, false));
    }

    @Test
    public void givenCellOnPositionZeroZeroThenReturnCorrectNeighbours() {
        List<Index> neighbours = controller.getNeighbours(new Index(0, 0));
        assertEquals(3, neighbours.size());
        assertTrue(neighbours.contains(new Index(0, 1)));
        assertTrue(neighbours.contains(new Index(1, 0)));
        assertTrue(neighbours.contains(new Index(1, 1)));
    }

    @Test
    public void givenCellOnPositionOneOneThenReturnCorrectNeighbours() {
        List<Index> neighbours = controller.getNeighbours(new Index(1, 1));
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
        List<Index> neighbours = controller.getNeighbours(new Index(0, 1));
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
        GameOfLifeController spyController = Mockito.spy(new GameOfLifeController(spyGrid));

        spyController.calculateNextGeneration();
        verify(spyController, times(1)).getNeighbours(new Index(0, 0));
        verify(spyController, times(1)).getNeighbours(new Index(0, 1));
        verify(spyController, times(1)).getNeighbours(new Index(1, 0));
        verify(spyController, times(1)).getNeighbours(new Index(1, 1));
        verify(spyController, times(4)).willSurviveToNextGeneration(3, true);
        verify(spyGrid, times(1)).setCellStatus(new Index(0, 0), true);
        verify(spyGrid, times(1)).setCellStatus(new Index(0, 1), true);
        verify(spyGrid, times(1)).setCellStatus(new Index(1, 0), true);
        verify(spyGrid, times(1)).setCellStatus(new Index(1, 1), true);
    }
}
