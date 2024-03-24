package se.schnell.solutions.gameOfLife;

public record Index(int x, int y) {
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Index index) {
            return index.x == x && index.y == y;
        }
        return false;
    }
}
