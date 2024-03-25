package se.schnell.solutions.gameOfLife;

public class GameOfLifeGrid {
    private final int numberOfRows;
    private final int numberOfColumns;
    private boolean[][] grid;

    public GameOfLifeGrid(int numberOfRows, int numberOfColumns, double aliveProbability) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.initializeGrid(aliveProbability);
    }

    private void initializeGrid(double aliveProbability) {
        this.grid = new boolean[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                grid[i][j] = Math.random() < aliveProbability;
            }
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setCellStatus(Index index, boolean status) {
        this.grid[index.x()][index.y()] = status;
    }

    public boolean getCellStatus(Index index) {
        return this.grid[index.x()][index.y()];
    }
}
