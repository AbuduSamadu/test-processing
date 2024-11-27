package abudu.test.testprocessingtool.models;

import abudu.test.testprocessingtool.utils.RegexValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TextProcessor handles regex-based operations such as searching,
 * matching, and replacing text within a given string.
 */
public class TextProcessor {
    private final RegexValidator regexValidator;

    /**
     * Constructor initializes the TextProcessor with a RegexValidator instance.
     */
    public TextProcessor(RegexValidator regexValidator) {
        this.regexValidator = regexValidator;
    }

    public String search(String text, String regex) {
        regexValidator.validateInputs(text, regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder results = new StringBuilder();
        int matchCount = 0;

        while (matcher.find()) {
            results.append("Match ").append(++matchCount)
                    .append(": ").append(matcher.group())
                    .append(" at index ").append(matcher.start()).append("\n");
        }

        return matchCount > 0 ? results.toString() : "No matches found.";
    }

    /**
     * Replaces all occurrences of the regex pattern in the input text with the replacement string.
     *
     * @param text        The input text to process.
     * @param regex       The regex pattern to match.
     * @param replacement The string to replace matches with.
     * @return The modified text after replacement.
     */
    public String replace(String text, String regex, String replacement) {
        regexValidator.validateInputs(text, regex);
        if (replacement == null) {
            throw new IllegalArgumentException("Replacement string cannot be null.");
        }

        return text.replaceAll(regex, replacement);
    }



}