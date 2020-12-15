package pract15.utils;

import pract15.interfaces.Item;

public class ItemsSorter {

    public static void sort(Item[] items) {
        int size = 0;
        while (items[size] != null)
            size++;

        for (int i = 0; i < size - 1; ++i)
            for (int j = i + 1; j < size; ++j)
                if (items[i].getCost() < items[j].getCost()) {
                    var temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
    }
}
