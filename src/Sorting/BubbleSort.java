package Sorting;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sortable<T> {
    private boolean ascending;

    public BubbleSort() {
        this.ascending = true;
    }

    @Override
    public List<T> sort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shouldSwap(list.get(j), list.get(j + 1))) {
                    swap(list, j, j + 1);
                }
            }
        }
        return list;
    }

    @Override
    public String getAlgorithmName() {
        return "Bubble Sort";
    }

    @Override
    public void setAscendingOrder(boolean ascending) {
        this.ascending = ascending;
    }

    private boolean shouldSwap(T a, T b) {
        if (ascending) {
            return a.compareTo(b) > 0;
        } else {
            return a.compareTo(b) < 0;
        }
    }

    private void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
