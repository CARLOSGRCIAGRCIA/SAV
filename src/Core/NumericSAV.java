package Core;

import Parsing.Parser;
import Sorting.Sortable;

import java.util.ArrayList;
import java.util.List;

public class NumericSAV extends AbstractSAV<Integer> {
    private int pauseDuration;
    private Sortable<Integer> sorter;
    private String algorithmName;
    private long totalTime;


    public NumericSAV(Parser<Integer> parser, Sortable<Integer> sorter, String algorithmName, int pauseDuration) {
        super(parser);
        this.sorter = sorter;
        this.algorithmName = algorithmName;
        this.pauseDuration = pauseDuration;
    }
    @Override
    public List<String> process(List<String> values) {
        List<Integer> parsedValues = parseValues(values);

        if (parsedValues.contains(null)) {
            System.out.println("Valores inválidos encontrados en la lista.");
            return null;
        }

        List<Integer> sortedValues = sorter.sort(parsedValues);

        long startTime = System.currentTimeMillis();

        List<String> sortedStringValues = new ArrayList<>();
        for (Integer value : sortedValues) {
            sortedStringValues.add(value.toString());
        }

        long endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;

        return sortedStringValues;
    }
    public long getTotalTime() {
        return totalTime;
    }
}
