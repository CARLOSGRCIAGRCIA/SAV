package Sorting;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sortable<T> {

    private boolean ascending;

    public InsertionSort() {
        this.ascending = true;
    }

    @Override
    public List<T> sort(List<T> values) {
        for (int i = 1; i < values.size(); i++) {
            T key = values.get(i);
            int j = i - 1;
            while (j >= 0 && shouldSwap(values.get(j), key)) {
                values.set(j + 1, values.get(j));
                j--;
            }
            values.set(j + 1, key);
        }
        return values;
    }

    @Override
    public String getAlgorithmName() {
        return "Insertion Sort";
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
}
