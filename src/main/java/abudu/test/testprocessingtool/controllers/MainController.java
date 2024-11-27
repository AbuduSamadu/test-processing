package abudu.test.testprocessingtool.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MainController {

;


    public TextField regexReplacerField;
    @FXML
    private TextArea textAreaInput;

    @FXML
    private TextField regexPatternField;

    @FXML
    private TextArea textAreaOutput;

    private final TextProcessingController textProcessingController;
    private final RegexProcessingController regexProcessingController;



    public MainController( ) {
        textProcessingController = new TextProcessingController();
        regexProcessingController = new RegexProcessingController();

    }
    @FXML
    private void handleSearch() {
        String text = textAreaInput.getText();
        String regex = regexPatternField.getText();
        String result = textProcessingController.handleSearch(text, regex);
        textAreaOutput.setText(result);
    }

    @FXML
    private void handleReplace() {
        String text = textAreaInput.getText();
        String regex = regexPatternField.getText();
        String replacement = regexReplacerField.getText();
        String result = textProcessingController.handleReplace(text, regex, replacement);
        textAreaOutput.setText(result);
    }

    @FXML
    private void handleExactMatch() {
        String text = textAreaInput.getText();
        String regex = regexPatternField.getText();
        String result = textProcessingController.handleExactMatch(text, regex);
        textAreaOutput.setText(result);
    }

    @FXML
    private void handleRegexValidation() {
        String text = textAreaInput.getText();
        String regex = regexPatternField.getText();
        String result = regexProcessingController.handleRegexValidation(text, regex);
        textAreaOutput.setText(result);
    }

    @FXML
    private void handleClear() {
        textAreaInput.clear();
        regexPatternField.clear();
        textAreaOutput.clear();
    }
}