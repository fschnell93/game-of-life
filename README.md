# Game of Life
Implementation of Conway's Game of Life.

![Alt text for the image](assets/game-of-life.png)

## How to run
Make sure you have gradle installed and in your path.

To build:
```bash
gradlew clean build
```

To run:
```bash
gradlew run --args="<numberOfRows> <numberOfColumns> <alivePorbability>"
```

Where numberOfRows is the number of rows in the grid, numberOfColumns is the number of columns in the grid and aliveProbability is a value between 0.0 and 1.0 that determines the probability of a cell being alive at the initial state.

For example:
```bash
gradlew run --args="20 20 0.5"
```

This will create a 20x20 grid with a 50% probability of a cell being alive at the initial state.

## How to test
To run tests:
```bash
gradlew test
```