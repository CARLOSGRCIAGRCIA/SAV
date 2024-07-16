package Sorting;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sortable<T> {

    private boolean ascending;

    @Override
    public List<T> sort(List<T> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.size(); j++) {
                if ((ascending && values.get(j).compareTo(values.get(minIndex)) < 0) ||
                        (!ascending && values.get(j).compareTo(values.get(minIndex)) > 0)) {
                    minIndex = j;
                }
            }
            swap(values, i, minIndex);
        }
        return values;
    }

    @Override
    public String getAlgorithmName() {
        return "Selection Sort";
    }

    @Override
    public void setAscendingOrder(boolean ascending) {
        this.ascending = ascending;
    }

    private void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
