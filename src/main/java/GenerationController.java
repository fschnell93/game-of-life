import java.util.ArrayList;
import java.util.List;

public class GenerationController {

    public GenerationController() {

    }

    public void calculateNextGeneration(GameOfLifeGrid grid) {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getColumns(); j++) {
                int numberOfAliveNeighbours = 0;
                List<Index> neighbours = getNeighbours(grid.getRows(), grid.getColumns(), i, j);
                for (Index neighbour : neighbours) {
                    if (grid.getCellAlive(neighbour)) {
                        numberOfAliveNeighbours++;
                    }
                }
                var index = new Index(i, j);
                var liveNextGeneration = shouldLiveNextGeneration(numberOfAliveNeighbours, grid.getCellAlive(index));
                grid.setCellAlive(index, liveNextGeneration);
            }
        }
    }

    public List<Index> getNeighbours(int numRows, int numColumns, int x, int y) {
        List<Index> neighbours = new ArrayList<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < numRows && j >= 0 && j < numColumns && !(i == x && j == y)) {
                    neighbours.add(new Index(i, j));
                }
            }
        }
        return neighbours;
    }

    public boolean shouldLiveNextGeneration(int numberOfAliveNeighbours, boolean isAlive) {
        if (isAlive) {
            if (numberOfAliveNeighbours < 2) {
                return false;
            } else {
                return numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
            }
        } else {
            return numberOfAliveNeighbours == 3;
        }
    }
}
