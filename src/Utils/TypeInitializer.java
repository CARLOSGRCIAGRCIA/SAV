package Utils;
import Parsing.*;
public class TypeInitializer {
    private Parser<?> typeParser;
    private String typeName;

    public TypeInitializer(String typeArg) {
        switch (typeArg) {
            case "n":
                typeParser = new IntegerParser();
                typeName = "Numérico";
                break;
            case "c":
                typeParser = new CharacterParser();
                typeName = "Carácter";
                break;
            default:
                System.out.println("Tipo no válido.");
                break;
        }
    }

    public Parser<?> getTypeParser() {
        return typeParser;
    }

    public String getTypeName() {
        return typeName;
    }
}