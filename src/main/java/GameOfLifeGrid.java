public class GameOfLifeGrid {
    private final int rows;
    private final int columns;
    private boolean[][] grid;

    public GameOfLifeGrid(int rows, int columns, float aliveProbability) {
        this.rows = rows;
        this.columns = columns;
        this.initializeGrid(aliveProbability);
    }

    private void initializeGrid(float aliveProbability) {
        this.grid = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Math.random() < aliveProbability;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setCellAlive(Index index, boolean value) {
        this.grid[index.x()][index.y()] = value;
    }

    public boolean getCellAlive(Index index) {
        return this.grid[index.x()][index.y()];
    }
}
