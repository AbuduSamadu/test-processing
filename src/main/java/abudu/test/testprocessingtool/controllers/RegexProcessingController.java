package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.utils.RegexValidator;

import java.util.Arrays;

/**
 * RegexProcessingController handles user interactions with regex-related functionality
 * such as validating, matching, finding all matches, and replacing patterns in text.
 */
public class RegexProcessingController {
    private final RegexProcessor regexProcessor;


    /**
     * Constructor initializes the controller with an instance of RegexProcessor.
     */
    public RegexProcessingController(RegexProcessor regexProcessor) {
        this.regexProcessor = regexProcessor;
    }

    /**
     * Handles the validation of a regex pattern.
     *
     * @param regex The regex pattern to validate.
     * @return A message indicating whether the regex is valid or not.
     */
    public String handleRegexValidation(String regex) {
        return RegexValidator.isValidRegex(regex) ? "The regex pattern is valid." : "Invalid regex pattern.";
    }

    /**
     * Handles searching for the first match of a regex pattern in the input text.
     *
     * @param text  The input text to search.
     * @param regex The regex pattern to search for.
     * @return A message indicating whether a match was found.
     */
    public String handleSearchForMatch(String text, String regex) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }

        return regexProcessor.matches(text, regex) ? "Match found!" : "No match found.";
    }

    /**
     * Handles finding all matches of a regex pattern in the input text.
     *
     * @param text  The input text to search.
     * @param regex The regex pattern to find matches for.
     * @return A string representation of all matches or a message indicating no matches.
     */
    public String handleFindAllMatches(String text, String regex) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }

        try {
            String[] matches = regexProcessor.findAllMatches(text, regex);
            return matches.length > 0 ? "Matches found: " + Arrays.toString(matches) : "No matches found.";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Handles replacing all occurrences of a regex pattern in the input text with a replacement string.
     *
     * @param text        The input text to process.
     * @param regex       The regex pattern to match.
     * @param replacement The string to replace matches with.
     * @return The modified text after replacement.
     */
    public String handleReplaceAll(String text, String regex, String replacement) {
        if (!RegexValidator.isValidRegex(regex)) {
            return "Invalid regex pattern.";
        }

        try {
            return regexProcessor.replaceAll(text, regex, replacement);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}