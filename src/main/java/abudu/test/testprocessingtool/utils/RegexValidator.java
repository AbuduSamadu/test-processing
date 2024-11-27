package abudu.test.testprocessingtool.utils;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * RegexValidator is a utility class that provides methods for validating regex patterns.
 * It ensures that the regex patterns are syntactically correct and can be compiled by Java's regex engine.
 */
public class RegexValidator {

    // Private constructor to prevent instantiation
    private RegexValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Validates whether the given regex pattern is valid.
     * It tries to compile the pattern and returns true if it's valid, false otherwise.
     *
     * @param regex The regex pattern to validate.
     * @return True if the regex pattern is valid, false otherwise.
     */
    public static boolean isValidRegex(String regex) {
        if (regex == null || regex.isEmpty()) {
            return false; // Null or empty regex is considered invalid
        }

        try {
            Pattern.compile(regex); // Tries to compile the regex
            return true; // Regex is valid
        } catch (PatternSyntaxException e) {
            return false; // If there's a syntax error, the regex is invalid
        }
    }

    public void validateInputs(String text, String regex) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }
        if (regex == null || regex.isEmpty()) {
            throw new IllegalArgumentException("Regex pattern cannot be null or empty.");
        }
    }
}