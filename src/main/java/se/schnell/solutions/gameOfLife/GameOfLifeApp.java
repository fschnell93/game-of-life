package se.schnell.solutions.gameOfLife;

public class GameOfLifeApp {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Three arguments required");
        }
        int numberOfRows = Integer.parseInt(args[0]);
        int numberOfColumns = Integer.parseInt(args[1]);
        float aliveProbability = Float.parseFloat(args[2]);
        GameOfLifeGrid grid = new GameOfLifeGrid(numberOfRows, numberOfColumns, aliveProbability);
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
        Thread.sleep(1000);
    }
}
