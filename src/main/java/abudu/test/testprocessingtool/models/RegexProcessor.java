package abudu.test.testprocessingtool.models;

import abudu.test.testprocessingtool.utils.AlertUtility;
import abudu.test.testprocessingtool.utils.RegexValidator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;


public class RegexProcessor {

    private final RegexValidator regexValidator;

    /**
     * Constructor initializes the RegexProcessor with a TextProcessor instance.
     */
    public RegexProcessor(RegexValidator regexValidator) {
        this.regexValidator = regexValidator;
    }


    public String[] findAllMatches(String text, String regex) {
        regexValidator.validateInputs(text, regex);
        Pattern pattern = Pattern.compile(regex , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        return matcher.results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }


    public boolean matches(String text, String regex) {
        regexValidator.validateInputs(text, regex);
        return Pattern.matches(regex, text);
    }


    public String replaceAll(String text, String regex, String replacement) {
        regexValidator.validateInputs(text, regex);
        if (replacement == null) {
            AlertUtility.showWarningAlert("Error", "Replacement string cannot be null.", "Please provide a valid replacement string.");
            return null;

        }

        return text.replaceAll(regex, replacement);
    }


}