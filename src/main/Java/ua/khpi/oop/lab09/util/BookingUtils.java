package ua.khpi.oop.lab09.util;

import java.util.List;

public class BookingUtils {

    public static <T extends Comparable<T>> T findMaximum(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }
        T max = items.get(0);
        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}