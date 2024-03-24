public class GameOfLife {
    public static void main(String[] args) throws InterruptedException {
        GameOfLifeGrid grid = new GameOfLifeGrid(20, 20, 0.5f);
        GameOfLifeController controller = new GameOfLifeController(grid);
        System.out.println("Initial generation:");
        printGrid(grid.getGrid());

        while (true) {
            controller.calculateNextGeneration();
            System.out.println("Next generation:");
            printGrid(grid.getGrid());
        }
    }

    private static void printGrid(boolean[][] grid) throws InterruptedException {
        for (var row : grid) {
            for (var cell : row) {
                System.out.print(cell ? " O " : " . ");
            }
            System.out.println();
        }
        System.out.println();
        Thread.sleep(2000);
    }
}
