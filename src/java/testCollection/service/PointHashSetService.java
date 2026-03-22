package testCollection.service;

import testCollection.collection_factory.CollectionFactory;
import testCollection.point.Point;

import java.util.Set;

public class PointHashSetService {

    private final Set<Point> points = CollectionFactory.createHashSet();

    public int getSize() {
        return points.size();
    }

    public boolean isPointExists(Point point) {
        return points.contains(point);
    }

    public Point getPoint() {
        return points.iterator().next();
    }
}
