package day3;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int p = 31;
        return p * x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Point p = (Point) obj;
        return p.x == this.x && p.y == this.y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
