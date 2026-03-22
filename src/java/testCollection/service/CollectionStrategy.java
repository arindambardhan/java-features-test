package testCollection.service;

import testCollection.point.Point;

import java.util.Collection;

@FunctionalInterface
public interface CollectionStrategy {
    Collection<Point> create();
}