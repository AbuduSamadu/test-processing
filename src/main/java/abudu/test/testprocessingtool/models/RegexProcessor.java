package abudu.test.testprocessingtool.models;

import abudu.test.testprocessingtool.utils.RegexValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

/**
 * RegexProcessor provides methods to validate, compile, and perform operations
 * using regular expressions, such as matching, searching, and validating patterns.
 */
public class RegexProcessor {

    private final RegexValidator regexValidator;

    /**
     * Constructor initializes the RegexProcessor with a TextProcessor instance.
     */
    public RegexProcessor(RegexValidator regexValidator) {
        this.regexValidator = regexValidator;
    }

    /**
     * Finds and returns all matches of the regex pattern in the input text.
     *
     * @param text  The input text to process.
     * @param regex The regex pattern to match.
     * @return An array of strings containing all matches found.
     */
    public String[] findAllMatches(String text, String regex) {
        regexValidator.validateInputs(text, regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }

    /**
     * Checks if the given regex pattern matches the input text.
     *
     * @param text  The input text to test.
     * @param regex The regex pattern to match.
     * @return True if the pattern matches the text, false otherwise.
     */
    public boolean matches(String text, String regex) {
        regexValidator.validateInputs(text, regex);
        return Pattern.matches(regex, text);
    }

    /**
     * Replaces all occurrences of the regex pattern in the input text with a replacement string.
     *
     * @param text        The input text to process.
     * @param regex       The regex pattern to match.
     * @param replacement The replacement string.
     * @return The resulting text after replacement.
     */
    public String replaceAll(String text, String regex, String replacement) {
        regexValidator.validateInputs(text, regex);
        if (replacement == null) {
            throw new IllegalArgumentException("Replacement string cannot be null.");
        }

        return text.replaceAll(regex, replacement);
    }


}