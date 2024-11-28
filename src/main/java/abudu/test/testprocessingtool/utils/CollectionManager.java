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


}
