package testCollection;

import testCollection.service.*;
import testCollection.point.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ArrayList ===");

        PointArrayListService arrayListService = new PointArrayListService();
        System.out.println("Collection Size: " + normalize(arrayListService.getSize()));

        long start = System.nanoTime();
        boolean pointByIdFromList = arrayListService.isPointExists(arrayListService.getPoint());
        System.out.println("Time taken by ArrayList " + elapsed(start) + " microseconds");
        System.out.println("IsThere: " + pointByIdFromList);

        System.out.println("=== HashSet ===");

        PointHashSetService hashSetService = new PointHashSetService();
        System.out.println("Collection Size: " + normalize(hashSetService.getSize()));

        start = System.nanoTime();

        boolean byIdFromSet = hashSetService.isPointExists(hashSetService.getPoint());
        System.out.println("Time taken by HashSet " + elapsed(start) + " microseconds");
        System.out.println("IsThere: " + byIdFromSet);
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
