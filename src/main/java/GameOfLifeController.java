import java.util.ArrayList;
import java.util.List;

public class GameOfLifeController {
    private final GameOfLifeGrid grid;

    public GameOfLifeController(GameOfLifeGrid grid) {
        this.grid = grid;
    }

    public void calculateNextGeneration() {
        for (int i = 0; i < grid.getNumberOfRows(); i++) {
            for (int j = 0; j < grid.getNumberOfColumns(); j++) {
                var index = new Index(i, j);
                List<Index> neighbours = getNeighbours(index);
                int numberOfLivingNeighbours = (int) neighbours
                        .stream()
                        .map(grid::getCellStatus)
                        .filter(isAlive -> isAlive).count();
                boolean liveNextGeneration = willSurviveToNextGeneration(numberOfLivingNeighbours, grid.getCellStatus(index));
                grid.setCellStatus(index, liveNextGeneration);
            }
        }
    }

    public List<Index> getNeighbours(Index index) {
        List<Index> neighbours = new ArrayList<>();
        int x = index.x();
        int y = index.y();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                boolean isCurrentCell = i == x && j == y;
                boolean withinRowBounds = i >= 0 && i < grid.getNumberOfRows();
                boolean withinColumnBounds = j >= 0 && j < grid.getNumberOfColumns();
                if (!isCurrentCell && withinRowBounds && withinColumnBounds) {
                    neighbours.add(new Index(i, j));
                }
            }
        }
        return neighbours;
    }

    public boolean willSurviveToNextGeneration(int numberOfLivingNeighbours, boolean isAlive) {
        if (isAlive) {
            if (numberOfLivingNeighbours < 2) {
                return false;
            } else {
                return numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3;
            }
        } else {
            return numberOfLivingNeighbours == 3;
        }
    }
}
