package pract9;

import java.util.ArrayList;

public class QuickSort {
    public void quickSort(ArrayList<Student> arr, int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);

            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    private static int partition(ArrayList<Student> arr, int from, int to) {
        StudentComparator scomp = new StudentComparator();
        int indexLeft = from;
        int indexRight = to;

        Student pivot = arr.get(from + (to - from) / 2);
        while (indexLeft <= indexRight) {

            while (scomp.compare(arr.get(indexLeft), pivot) < 0) {
                indexLeft++;
            }

            while (scomp.compare(arr.get(indexRight), pivot) > 0) {
                indexRight--;
            }

            if (indexLeft <= indexRight) {
                swap(arr, indexLeft, indexRight);
                indexLeft++;
                indexRight--;
            }
        }

        return indexLeft;
    }

    private static void swap(ArrayList<Student> arr, int indexLeft, int indexRight)
    {
        String tmp_name;
        int tmp_orders;

        // Меняем местами поля двух объектов-студентов.
        tmp_name = arr.get(indexLeft).getName();
        tmp_orders = arr.get(indexLeft).getSumOrder();

        arr.get(indexLeft).setName(arr.get(indexRight).getName());
        arr.get(indexLeft).setSumOrder(arr.get(indexRight).getSumOrder());

        arr.get(indexRight).setName(tmp_name);
        arr.get(indexRight).setSumOrder(tmp_orders);
    }
}
