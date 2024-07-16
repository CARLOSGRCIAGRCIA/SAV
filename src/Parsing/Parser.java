package Parsing;

import java.util.List;

public interface Parser<T> {
    T parse(String value);
    List<T> parseValues(List<String> values);
}