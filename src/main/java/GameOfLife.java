public class GameOfLife {

    public static void main(String[] args) throws InterruptedException {
        GameOfLifeGrid grid = new GameOfLifeGrid(20, 20, 0.5f);
        GenerationController controller = new GenerationController();
        System.out.println("Initial generation");
        printGrid(grid);
        while (true) {
            controller.calculateNextGeneration(grid);
            System.out.println("Next generation:");
            printGrid(grid);
        }
    }

    public static void printGrid(GameOfLifeGrid grid) throws InterruptedException {
        for (int j = 0; j < grid.getRows(); j++) {
            for (int k = 0; k < grid.getColumns(); k++) {
                System.out.print(grid.getCellAlive(new Index(j, k)) ? " O " : " . ");
            }
            System.out.println();
        }
        System.out.println();
        Thread.sleep(2000);
    }
}

