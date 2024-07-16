package Core;

import Parsing.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSAV<T extends Comparable<T>> {
    protected Parser<T> parser;

    public AbstractSAV(Parser<T> parser) {
        this.parser = parser;
    }
    protected List<T> parseValues(List<String> values) {
        List<T> parsedValues = new ArrayList<>();
        for (String value : values) {
            T parsedValue = parser.parse(value);
            parsedValues.add(parsedValue);
        }
        return parsedValues;
    }
    public abstract List<String> process(List<String> values);

}
