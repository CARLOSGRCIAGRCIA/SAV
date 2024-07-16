package Utils;

import sav.ValueAdapter;

public class SortingValueAdapter implements ValueAdapter<String> {
    @Override
    public int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return value.charAt(0);
        }
    }
}
