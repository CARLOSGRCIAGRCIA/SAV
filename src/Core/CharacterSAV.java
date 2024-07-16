package Core;

import Parsing.Parser;
import Sorting.Sortable;

import java.util.ArrayList;
import java.util.List;

public class CharacterSAV extends AbstractSAV<Character> {
    private int pauseDuration;
    private Sortable<Character> sorter;
    private String algorithmName;
    private long totalTime;

    public CharacterSAV(Parser<Character> parser, Sortable<Character> sorter, String algorithmName, int pauseDuration) {
        super(parser);
        this.sorter = sorter;
        this.algorithmName = algorithmName;
        this.pauseDuration = pauseDuration;
    }

    @Override
    public List<String> process(List<String> values) {
        List<Character> parsedValues = parseValues(values);

        if (parsedValues.contains(null)) {
            System.out.println("Valores inválidos encontrados en la lista.");
            return null;
        }

        long startTime = System.currentTimeMillis();

        List<Character> sortedValues = sorter.sort(parsedValues);

        long endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;

        List<String> stringList = convertToStringList(sortedValues);

        return stringList;
    }


    public List<String> convertToStringList(List<Character> values) {
        List<String> stringList = new ArrayList<>();
        for (Character value : values) {
            stringList.add(value.toString());
        }
        return stringList;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
