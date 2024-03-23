public class GenerationController {

    public GenerationController() {

    }

    public static boolean shouldLiveNextGeneration(int numberOfAliveNeighbours, boolean isAlive) {
        if (isAlive) {
            if (numberOfAliveNeighbours < 2) {
                return false;
            }
            else {
                return numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
            }
        } else {
            return numberOfAliveNeighbours == 3;
        }
    }
}
