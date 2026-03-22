package testCollection.collection_factory;

import testCollection.point.Point;

import java.util.*;

public class CollectionFactory {

    private static final int SIZE = 1_000_000_0;
    private static final Random RANDOM = new Random();

    public static List<Point> createArrayList() {
        return new ArrayList<>(generatePoints());
    }

    public static Set<Point> createHashSet() {
        return new HashSet<>(generatePoints());
    }

    public static Set<Point> createLinkedHashSet() {
        return new LinkedHashSet<>(generatePoints());
    }

    public static Set<Point> createTreeSet() {
        return new TreeSet<>(generatePoints());
    }

    private static List<Point> generatePoints() {
        List<Point> points = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            points.add(new Point(
                    RANDOM.nextDouble(100),
                    RANDOM.nextDouble(100),
                    RANDOM.nextDouble(100)
            ));
        }
        return points;
    }

}