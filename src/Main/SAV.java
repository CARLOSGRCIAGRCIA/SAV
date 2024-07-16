package Main;

import Parsing.Parser;
import Sorting.Sortable;
import Sorting.SortingFactory;
import Utils.*;

import java.util.List;

public class SAV {
    public static void main(String[] args) {
        ArgumentProcessor argumentProcessor = new ArgumentProcessor(args);
        if (!argumentProcessor.validateArguments()) {
            return;
        }
        TypeInitializer typeInitializer = new TypeInitializer(argumentProcessor.getTypeArg());
        Parser<?> typeParser = typeInitializer.getTypeParser();
        String typeName = typeInitializer.getTypeName();

        ValueProcessor valueProcessor = new ValueProcessor(argumentProcessor.getInputArg(), argumentProcessor.getValuesArg(), argumentProcessor.getRangeArg(), typeParser);
        List<String> valueStrings = valueProcessor.processValues();

        SortingFactory sortingFactory = SortingFactory.getInstance();
        Sortable<?> sorter = sortingFactory.createSorter(argumentProcessor.getAlgorithmArg(), argumentProcessor.getOrderArg());
        sorter.setAscendingOrder(argumentProcessor.getOrderArg().equals("az") || argumentProcessor.getOrderArg().equals("ZA"));

        ResultProcessor resultProcessor = new ResultProcessor(typeName, argumentProcessor.getPauseArg(), argumentProcessor.getOrderArg());
        resultProcessor.processAndPrintResults(typeParser, sorter, valueStrings);
    }
}
