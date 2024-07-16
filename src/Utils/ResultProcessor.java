package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Core.*;
import Parsing.*;
import Sorting.*;
import sav.*;

public class ResultProcessor {
    private String typeName;
    private String pauseArg;
    private String orderArg;
    int min = 0;
    int max = 100;

    public ResultProcessor(String typeName, String pauseArg, String orderArg) {
        this.typeName = typeName;
        this.pauseArg = pauseArg;
        this.orderArg = orderArg;
    }

    public void processAndPrintResults(Parser<?> typeParser, Sortable<?> sorter, List<String> valueStrings) {
        sorter.setAscendingOrder(orderArg.equals("az") || orderArg.equals("ZA"));

        List<String> sortedStringValues = processValues(typeParser, sorter, valueStrings);
        if (sortedStringValues != null) {
            printResults(valueStrings, sortedStringValues, sorter.getAlgorithmName(), typeName, Integer.parseInt(pauseArg));
        }
    }

    private List<String> processValues(Parser<?> typeParser, Sortable<?> sorter, List<String> valueStrings) {
        if (typeName.equals("Numérico")) {
            NumericSAV numericSAV = new NumericSAV((Parser<Integer>) typeParser, (Sortable<Integer>) sorter, sorter.getAlgorithmName(), Integer.parseInt(pauseArg));
            return numericSAV.process(valueStrings);
        } else if (typeName.equals("Carácter")) {
            CharacterSAV characterSAV = new CharacterSAV((Parser<Character>) typeParser, (Sortable<Character>) sorter, sorter.getAlgorithmName(), Integer.parseInt(pauseArg));
            return characterSAV.process(valueStrings);
        }
        return null;
    }

    private void printResults(List<String> values, List<String> sortedValues, String algorithmName, String typeName, int pauseDuration) {
        int totalDelay = pauseDuration * values.size();
        System.out.println("Tipo: [" + typeName + "]");
        System.out.println("Valores:");

        HorizontalConsoleRenderer<String> valueRenderer = new HorizontalConsoleRenderer<>();
        SavSettings<String> valueSettings = new SavSettings<>(values, pauseDuration, "-1000", "1000", new SortingValueAdapter(), true);
        valueRenderer.render(new SavGenerator<String>() {
            @Override
            public void sortItems(List<String> items, boolean ascending, RenderOperation<String> renderOperation) {
                List<String> renderedItems = renderedItems(items, typeName);
                renderOperation.render(renderedItems);
            }
        }, valueSettings);

        System.out.println("Ordenamiento:");

        HorizontalConsoleRenderer<String> sortedRenderer = new HorizontalConsoleRenderer<>();
        SavSettings<String> sortedSettings = new SavSettings<>(sortedValues, pauseDuration, "-1000", "1000", new SortingValueAdapter(), true);
        sortedRenderer.render(new SavGenerator<String>() {
            @Override
            public void sortItems(List<String> items, boolean ascending, RenderOperation<String> renderOperation) {
                List<String> currentList = new ArrayList<>(items);
                for (int i = 1; i <= items.size(); i++) {
                    List<String> subList = currentList.subList(0, i);
                    renderOperation.render(renderedItems(subList, typeName));
                }
            }
        }, sortedSettings);

        System.out.println("Algoritmo: " + algorithmName);
        System.out.println("Tiempo total: " + (pauseDuration * values.size()) + " ms");
    }

    private List<String> renderedItems(List<String> items, String typeName) {
        List<String> renderedItems = new ArrayList<>();
        for (String item : items) {
            if (typeName.equals("Carácter")) {
                int charValue = item.charAt(0);
                int asterisksCount = (charValue - 'A' + 1); // A=1, B=2, ..., Z=26
                String renderedItem = "*".repeat(asterisksCount) + " " + item;
                renderedItems.add(renderedItem);
            } else {
                renderedItems.add(item);
            }
        }
        return renderedItems;
    }

}
