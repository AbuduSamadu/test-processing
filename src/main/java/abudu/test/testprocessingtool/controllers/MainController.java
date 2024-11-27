package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.RegexProcessor;
import abudu.test.testprocessingtool.models.TextProcessor;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    private TextArea textAreaInput;

    @FXML
    private TextField regexPatternField;

    @FXML
    private TextArea textAreaOutput;

    private TextProcessingController textProcessingController;

    public MainController() {
        // Initialize the TextProcessingController with appropriate processors
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
        String replacement = ""; // You might want to add a TextField for replacement input in the FXML
        String result = textProcessingController.handleReplace(text, regex, replacement);
        textAreaOutput.setText(result);
    }

    @FXML
    private void handleClear() {
        textAreaInput.clear();
        regexPatternField.clear();
        textAreaOutput.clear();
    }
}