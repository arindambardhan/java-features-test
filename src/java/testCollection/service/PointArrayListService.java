package testCollection.service;

import testCollection.collection_factory.CollectionFactory;
import testCollection.point.Point;

import java.util.List;

public class PointArrayListService {

    private final List<Point> points = CollectionFactory.createArrayList();

    public int getSize() {
        return points.size();
    }

    public boolean isPointExists(Point element) {
        return points.contains(element);
    }

    public Point getPoint() {
        return points.getLast();
    }

}
