package testCollection;

import testCollection.collection_factory.CollectionFactory;
import testCollection.point.Point;
import testCollection.service.PointCollectionService;

public class Main {

    public static void main(String[] args) {
        benchmark("HashSet",       new PointCollectionService(CollectionFactory::createHashSet));
        benchmark("TreeSet",       new PointCollectionService(CollectionFactory::createTreeSet));
        benchmark("ArrayList",     new PointCollectionService(CollectionFactory::createArrayList));
        benchmark("LinkedHashSet", new PointCollectionService(CollectionFactory::createLinkedHashSet));
    }

    private static void benchmark(String label, PointCollectionService service) {
        Point point = service.getPoint();

        System.out.println("=== " + label + " ===");
        System.out.println("Collection Size: " + normalize(service.getSize()));

        long start = System.nanoTime();
        boolean found = service.isPointExists(point);
        System.out.println("Time taken by " + label + ": " + elapsed(start) + " microseconds");
        System.out.println("IsThere: " + found);
    }

    private static long elapsed(long startNano) {
        return (System.nanoTime() - startNano) / 1_000;
    }

    private static String normalize(int size) {
        if (size >= 1_000_000) return (size / 1_000_000) + "M";
        if (size >= 1_000) return (size / 1_000) + "K";
        return String.valueOf(size);
    }
}