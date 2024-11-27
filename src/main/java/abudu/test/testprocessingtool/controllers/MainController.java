package abudu.test.testprocessingtool.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

;


    public TextField regexReplacerField;
    public ToggleButton toggleButton;
    public Label titleLabel;
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


    @FXML
    private void handleToggle() {
        if (toggleButton.isSelected()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/abudu/test/testprocessingtool/dashboard.fxml"));
                Stage stage = (Stage) toggleButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Data Management Dashboard");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            titleLabel.setText("Text Processing Tool");
            toggleButton.setText("Switch to Data Management Tool");
        }
    }
}