package Utils;

import java.util.HashMap;

public class ArgumentProcessor {
    private HashMap<String, String> argMap = new HashMap<>();
    private String algorithmArg;
    private String typeArg;
    private String orderArg;
    private String inputArg;
    private String rangeArg;
    private String valuesArg;
    private String pauseArg;
    public ArgumentProcessor(String[] args) {
        for (String arg : args) {
            String[] keyValue = arg.split("=");
            if (keyValue.length == 2) {
                argMap.put(keyValue[0].toLowerCase(), keyValue[1]);
            }
        }
        algorithmArg = argMap.get("a");
        typeArg = argMap.get("t");
        orderArg = argMap.get("o");
        inputArg = argMap.get("in");
        rangeArg = argMap.get("r");
        valuesArg = argMap.get("v");
        pauseArg = argMap.get("s");
    }
    public boolean validateArguments() {
        return validateAlgorithm() && validateType() && validateOrder() && validateInput() &&
                validateRange() && validateValues() && validatePause();
    }

    private boolean validateAlgorithm() {
        if (!argMap.containsKey("a")) {
            System.out.println("Error, tipo de algoritmo no definido.");
            return false;
        }
        return true;
    }

    private boolean validateType() {
        if (!argMap.containsKey("t")) {
            System.out.println("Error, tipo de dato no definido.");
            return false;
        }

        String typeName = argMap.get("t");
        if (!typeName.equals("n") && !typeName.equals("c")) {
            System.out.println("Error, tipo de dato no válido.");
            return false;
        }

        return true;
    }

    private boolean validateOrder() {
        if (!argMap.containsKey("o")) {
            System.out.println("Error, orden no definido.");
            return false;
        }
        if (!orderArg.equals("az") && !orderArg.equals("ZA") && !orderArg.equals("AZ") && !orderArg.equals("za")) {
            System.out.println("Error, valor para el orden no válido.");
            System.out.println("Parámetro \"o\" solo debe aceptar los valores \"az\", \"ZA\", \"AZ\" o \"za\".");
            return false;
        }
        return true;
    }

    private boolean validateInput() {
        if (!argMap.containsKey("in")) {
            System.out.println("Error, falta tipo de entrada de valores.");
            return false;
        }
        return true;
    }

    private boolean validateRange() {
        if (inputArg.equalsIgnoreCase("r") || inputArg.equalsIgnoreCase("R")) {
            if (!argMap.containsKey("r")) {
                System.out.println("Error, rango no definido.");
                return false;
            }
            try {
                int rangeValue = Integer.parseInt(rangeArg);
                if (rangeValue < 1 || rangeValue > 40) {
                    System.out.println("Error, el valor para el rango debe estar entre 1 y 40.");
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, valor para el rango inválido.");
                return false;
            }
        }
        return true;
    }

    private boolean validateValues() {
        if ((inputArg.equalsIgnoreCase("m") || inputArg.equalsIgnoreCase("M")) && valuesArg == null) {
            System.out.println("Error, parámetro \"v\" no proporcionado para entrada de valores \"m\" o \"M\".");
            return false;
        }
        return true;
    }

    private boolean validatePause() {
        if (!argMap.containsKey("s")) {
            System.out.println("Error, valor para pausa de retardo no definido.");
            return false;
        }
        try {
            int pauseValue = Integer.parseInt(pauseArg);
            if (pauseValue < 100 || pauseValue > 1000) {
                System.out.println("Error, el valor para pausa de retardo debe estar entre 100 y 1000.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error, valor para pausa de retardo inválido.");
            return false;
        }
        return true;
    }
    public String getAlgorithmArg() {
        return algorithmArg;
    }
    public String getTypeArg() {
        return typeArg;
    }
    public String getOrderArg() {
        return orderArg;
    }
    public String getInputArg() {
        return inputArg;
    }
    public String getRangeArg() {
        return rangeArg;
    }
    public String getValuesArg() {
        return valuesArg;
    }
    public String getPauseArg() {
        return pauseArg;
    }
}
