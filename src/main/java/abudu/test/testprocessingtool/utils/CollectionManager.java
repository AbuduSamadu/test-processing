package abudu.test.testprocessingtool.utils;

import abudu.test.testprocessingtool.models.DataItem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for advanced collection management operations.
 * Provides reusable methods for filtering, sorting, and transforming collections of DataItem objects.
 */
public class CollectionManager {

    /**
     * Filters a list of DataItem objects based on a keyword found in their name or value.
     *
     * @param items   The list of DataItem objects to filter.
     * @param keyword The keyword to filter by.
     * @return A filtered list of DataItem objects containing the keyword.
     */
    public static List<DataItem> filterByKeyword(List<DataItem> items, String keyword) {
        if (items == null || keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }
        return items.stream()
                .filter(item -> item.getName().contains(keyword) || item.getValue().contains(keyword))
                .collect(Collectors.toList());
    }

    /**
     * Sorts a list of DataItem objects by their name in ascending or descending order.
     *
     * @param items       The list of DataItem objects to sort.
     * @param ascending   True for ascending order, false for descending order.
     * @return A sorted list of DataItem objects.
     */
    public static List<DataItem> sortByName(List<DataItem> items, boolean ascending) {
        if (items == null) {
            return Collections.emptyList();
        }
        return items.stream()
                .sorted(ascending ? Comparator.comparing(DataItem::getName) : Comparator.comparing(DataItem::getName).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Groups a list of DataItem objects by their value field.
     *
     * @param items The list of DataItem objects to group.
     * @return A map where keys are values from the DataItem objects, and values are lists of DataItem objects with the same value.
     */
    public static Map<String, List<DataItem>> groupByValue(List<DataItem> items) {
        if (items == null) {
            return Collections.emptyMap();
        }
        return items.stream()
                .collect(Collectors.groupingBy(DataItem::getValue));
    }

    /**
     * Finds duplicates in a list of DataItem objects based on their ID.
     *
     * @param items The list of DataItem objects to check.
     * @return A list of duplicate DataItem objects.
     */
    public static List<DataItem> findDuplicatesById(List<DataItem> items) {
        if (items == null) {
            return Collections.emptyList();
        }
        Map<String, Long> idCounts = items.stream()
                .collect(Collectors.groupingBy(DataItem::getId, Collectors.counting()));

        return items.stream()
                .filter(item -> idCounts.get(item.getId()) > 1)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Removes all DataItem objects with a specific value from the collection.
     *
     * @param items The collection of DataItem objects.
     * @param value The value to filter out.
     * @return A new list with the specified value removed.
     */
    public static List<DataItem> removeByValue(List<DataItem> items, String value) {
        if (items == null || value == null) {
            return Collections.emptyList();
        }
        return items.stream()
                .filter(item -> !item.getValue().equals(value))
                .collect(Collectors.toList());
    }
}
