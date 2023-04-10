package stringcalculator;

import java.util.HashMap;
import java.util.Map;

public enum Delimiter {
    COMMA(","),
    COLON(":"),
    BLANK_STRING(" "),
    CUSTOM_START_STRING("//"),
    CUSTOM_END_STRING("\\n"),
    CUSTOM_END_SPLIT("n"),
    ESCAPE_CUSTOM_END_STRING("\\\\n");

    static final Map<String, String> REGEX_ESCAPE = new HashMap<>();

    static {
        REGEX_ESCAPE.put("+", "\\+");
        REGEX_ESCAPE.put("{", "\\{");
        REGEX_ESCAPE.put("(", "\\(");
        REGEX_ESCAPE.put(")", "\\)");
        REGEX_ESCAPE.put("[", "\\[");
    }

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public static boolean containsCustomDelimiter(String text) {
        return text.contains(CUSTOM_END_STRING.getValue()) && text.startsWith(CUSTOM_START_STRING.getValue());
    }

    public String getValue() {
        return value;
    }
}
