
package abudu.test.testprocessingtool.utils;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexValidator {

    public RegexValidator() {
    }
    // Validate the regex pattern
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
    // Validate the inputs to the methods
    public void validateInputs(String text, String regex) {
        if (text == null || text.isEmpty()) {
            AlertUtility.showErrorAlert("Validation Error", "Invalid Input Text", "Input text cannot be null or empty.");
            return;
        }
        if (regex == null || regex.isEmpty()) {
            AlertUtility.showErrorAlert("Validation Error", "Invalid Regex Pattern", "Regex pattern cannot be null or empty.");
        }
    }
}