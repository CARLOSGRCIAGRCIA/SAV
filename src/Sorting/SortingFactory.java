package Sorting;

public class SortingFactory {
    private static SortingFactory instance;

    private SortingFactory() {

    }

    public static SortingFactory getInstance() {
        if (instance == null) {
            synchronized (SortingFactory.class) {
                if (instance == null) {
                    instance = new SortingFactory();
                }
            }
        }
        return instance;
    }

    public Sortable<?> createSorter(String algorithm, String order) {
        Sortable<?> sorter = null;
        switch (algorithm.toLowerCase()) {
            case "s":
                sorter = new SelectionSort();
                break;
            case "b":
                sorter = new BubbleSort();
                break;
            case "i":
                sorter = new InsertionSort();
                break;
            default:
                System.out.println("Algoritmo no válido.");
                System.exit(1);
        }

        if (order.equalsIgnoreCase("za") || order.equalsIgnoreCase("AZ")) {
            sorter.setAscendingOrder(false);
        } else if (order.equalsIgnoreCase("az") || order.equalsIgnoreCase("ZA")) {
            sorter.setAscendingOrder(true);
        } else {
            System.out.println("Orden no válida.");
            System.exit(1);
        }

        return sorter;
    }
}
