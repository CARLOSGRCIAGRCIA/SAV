package Parsing;

import java.util.ArrayList;
import java.util.List;

public class CharacterParser implements Parser<Character> {

    @Override
    public Character parse(String value) {
        if (value.length() != 1 || !Character.isLetter(value.charAt(0))) {
            System.out.println("Valor inválido: " + value);
            return null;
        }
        return value.charAt(0);
    }

    @Override
    public List<Character> parseValues(List<String> values) {
        List<Character> parsedValues = new ArrayList<>();

        for (String value : values) {
            Character parsedValue = parse(value);
            if (parsedValue != null) {
                parsedValues.add(parsedValue);
            }
        }

        return parsedValues;
    }
}
