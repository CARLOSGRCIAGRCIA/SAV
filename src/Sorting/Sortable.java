package Sorting;

import java.util.List;

public interface Sortable<T> {
    List<T> sort(List<T> list);

    String getAlgorithmName();

    void setAscendingOrder(boolean ascending);
}