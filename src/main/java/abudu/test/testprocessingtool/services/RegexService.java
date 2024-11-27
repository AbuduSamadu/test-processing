package abudu.test.testprocessingtool.services;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.RegexValidator;

/**
 * RegexService provides higher-level methods for regex operations.
 * This service layer interacts with RegexProcessor to offer abstracted regex operations.
 */
public class RegexService {

    private final RegexProcessor regexProcessor;

    /**
     * Constructor initializes the RegexProcessor instance.
     */
    public RegexService(RegexProcessor regexProcessor) {
        this.regexProcessor = regexProcessor;
    }

    /**
     * Validates a given regex pattern.
     *
     * @param regex The regex pattern to validate.
     * @return True if the regex pattern is valid, false otherwise.
     */
    public boolean validateRegex(String regex) {
        return !RegexValidator.isValidRegex(regex);
    }

    /**
     * Finds all matches of the regex pattern in the input text.
     *
     * @param text  The input text to search through.
     * @param regex The regex pattern to match.
     * @return An array of matched strings, or an empty array if no matches are found.
     */
    public String[] findAllMatches(String text, String regex) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.findAllMatches(text, regex);
    }

    /**
     * Checks if the input text completely matches the regex pattern.
     *
     * @param text  The input text to test.
     * @param regex The regex pattern to match.
     * @return True if the input text matches the regex pattern, false otherwise.
     */
    public boolean isExactMatch(String text, String regex) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.matches(text, regex);
    }

    /**
     * Replaces all occurrences of the regex pattern in the text with a specified replacement string.
     *
     * @param text        The input text to modify.
     * @param regex       The regex pattern to replace.
     * @param replacement The string to replace the matched patterns.
     * @return The text with replaced patterns.
     */
    public String replaceAllMatches(String text, String regex, String replacement) {
        if (validateRegex(regex)) {
            throw new IllegalArgumentException("Invalid regex pattern.");
        }
        return regexProcessor.replaceAll(text, regex, replacement);
    }
}