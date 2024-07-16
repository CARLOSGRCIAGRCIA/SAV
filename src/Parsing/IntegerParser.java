package Parsing;

import java.util.ArrayList;
import java.util.List;

public class IntegerParser implements Parser<Integer> {

    @Override
    public Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + value);
            return null;
        }
    }

    @Override
    public List<Integer> parseValues(List<String> values) {
        List<Integer> parsedValues = new ArrayList<>();

        for (String value : values) {
            Integer parsedValue = parse(value);
            if (parsedValue != null) {
                parsedValues.add(parsedValue);
            }
        }

        return parsedValues;
    }

}
