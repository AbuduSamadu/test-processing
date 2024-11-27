package abudu.test.testprocessingtool.utils;

import abudu.test.testprocessingtool.models.DataItem;

import java.util.*;
import java.util.stream.Collectors;



public class CollectionManager {
    public static List<DataItem> filterByKeyword(List<DataItem> items, String keyword) {
        if (items == null || keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }
        return items.stream()
                .filter(item -> item.getName().contains(keyword) || item.getValue().contains(keyword))
                .collect(Collectors.toList());
    }


    public static List<DataItem> sortByName(List<DataItem> items, boolean ascending) {
        if (items == null) {
            return Collections.emptyList();
        }
        return items.stream()
                .sorted(ascending ? Comparator.comparing(DataItem::getName) : Comparator.comparing(DataItem::getName).reversed())
                .collect(Collectors.toList());
    }


    public static Map<String, List<DataItem>> groupByValue(List<DataItem> items) {
        if (items == null) {
            return Collections.emptyMap();
        }
        return items.stream()
                .collect(Collectors.groupingBy(DataItem::getValue));
    }


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


    public static List<DataItem> removeByValue(List<DataItem> items, String value) {
        if (items == null || value == null) {
            return Collections.emptyList();
        }
        return items.stream()
                .filter(item -> !item.getValue().equals(value))
                .collect(Collectors.toList());
    }
}
