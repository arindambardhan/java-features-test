package testCollection.service;

import testCollection.point.Point;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SuppressWarnings("all")
public class PointCollectionService {

    private static final Random RANDOM = new Random();

    private final Collection<Point> points;

    public PointCollectionService(CollectionStrategy strategy) {
        this.points = strategy.create();
    }

    public int getSize() {
        return points.size();
    }

    public boolean isPointExists(Point point) {
        return points.contains(point);
    }

    public Point getPoint() {
        int index = RANDOM.nextInt(points.size());
        if (points instanceof List<Point> list) {
            return list.get(index);
        }
        Iterator<Point> iterator = points.iterator();
        for (int i = 0; i < index; i++) iterator.next();
        return iterator.next();
    }
}