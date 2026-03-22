package testCollection.point;

public record Point(double breadth, double width, double length) implements Comparable<Point> {

    @Override
    public int compareTo(Point other) {
        int cmp = Double.compare(this.breadth, other.breadth);
        if (cmp != 0) return cmp;
        cmp = Double.compare(this.width, other.width);
        if (cmp != 0) return cmp;
        return Double.compare(this.length, other.length);

    }
}