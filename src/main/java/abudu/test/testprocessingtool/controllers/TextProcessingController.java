package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.TextProcessor;
import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.RegexValidator;

import java.util.Arrays;

/**
 * TextProcessingController handles user interactions and delegates operations
 * to the appropriate processor classes for text and regex-related tasks.
 */
public class TextProcessingController {

    private final TextProcessor textProcessor;
    private final RegexProcessor regexProcessor;

    /**
     * Constructor initializes the controller with instances of TextProcessor and RegexProcessor.
     */
    public TextProcessingController(TextProcessor textProcessor, RegexProcessor regexProcessor) {
        this.textProcessor = textProcessor;
        this.regexProcessor = regexProcessor;
    }

    /**
     * Handles regex search functionality.
     *
     * @param text  The input text to search.
     * @param regex The regex pattern to search for.
     * @return A string representing the results of the regex search.
     */
    public String handleSearch(String text, String regex) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }
        return textProcessor.search(text, regex);
    }

    /**
     * Handles regex replacement functionality.
     *
     * @param text        The input text to modify.
     * @param regex       The regex pattern to search for.
     * @param replacement The replacement string.
     * @return The modified text after replacements.
     */
    public String handleReplace(String text, String regex, String replacement) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }
        try {
            return textProcessor.replace(text, regex, replacement);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Handles functionality to find all matches of a regex pattern in the input text.
     *
     * @param text  The input text to search.
     * @param regex The regex pattern to match.
     * @return A string array containing all matches, or an error message.
     */
    public String handleFindAllMatches(String text, String regex) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }
        try {
            String[] matches = regexProcessor.findAllMatches(text, regex);
            return matches.length > 0
                    ? "Matches found: " + Arrays.toString(matches)
                    : "No matches found.";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Handles functionality to check if the text matches the regex pattern.
     *
     * @param text  The input text to validate.
     * @param regex The regex pattern to check.
     * @return A message indicating whether the text matches the pattern.
     */
    public String handleExactMatch(String text, String regex) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }
        return regexProcessor.matches(text, regex)
                ? "The text matches the regex pattern."
                : "The text does not match the regex pattern.";
    }
}