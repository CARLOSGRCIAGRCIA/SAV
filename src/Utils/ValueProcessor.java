package Utils;

import java.util.ArrayList;
import java.util.List;
import Parsing.*;
import java.util.Random;

public class ValueProcessor {
    private String inputArg;
    private String valuesArg;
    private String rangeArg;
    private Parser<?> typeParser;

    public ValueProcessor(String inputArg, String valuesArg, String rangeArg, Parser<?> typeParser) {
        this.inputArg = inputArg;
        this.valuesArg = valuesArg;
        this.rangeArg = rangeArg;
        this.typeParser = typeParser;
    }

    public List<String> processValues() {
        List<String> valueStrings = new ArrayList<>();

        if (inputArg.equalsIgnoreCase("r") || inputArg.equalsIgnoreCase("R")) {
            int rangeValue = Integer.parseInt(rangeArg);
            for (int i = 0; i < rangeValue; i++) {
                String randomValue = generateRandomValue(typeParser);
                valueStrings.add(randomValue);
            }
        } else if (inputArg.equalsIgnoreCase("m") || inputArg.equalsIgnoreCase("M")) {
            if (valuesArg != null) {
                String[] valueArray = valuesArg.split(",");
                for (String value : valueArray) {
                    valueStrings.add(typeParser.parse(value.trim()).toString());
                }
            }
        }

        return valueStrings;
    }

    private String generateRandomValue(Parser<?> parser) {
        if (parser instanceof IntegerParser) {
            int randomInt = new Random().nextInt(2001) - 1000;
            return String.valueOf(randomInt);
        } else if (parser instanceof CharacterParser) {
            char randomChar = (char) ('A' + new Random().nextInt(26));
            return String.valueOf(randomChar);
        }
        return "";
    }
}
