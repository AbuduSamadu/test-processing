package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.utils.AlertUtility;
import abudu.test.testprocessingtool.utils.LoggerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainController {


    public TextField regexReplacerField;
    public ToggleButton toggleButton;
    public Label titleLabel;
    @FXML
    private TextArea textAreaInput;

    @FXML
    private TextField regexPatternField;

    @FXML
    private TextArea textAreaOutput;

    @FXML
    private TextFlow textFlowOutput;


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
        highlightText(text, regex);
    }

    @FXML
    private void handleReplace() {
        String text = textAreaInput.getText();
        String regex = regexPatternField.getText();
        String replacement = regexReplacerField.getText();
        String result = textProcessingController.handleReplace(text, regex, replacement);
    }

    @FXML
    private void handleExactMatch() {
        String text = textAreaInput.getText();
        String regex = regexPatternField.getText();
        String result = textProcessingController.handleExactMatch(text, regex);
        textAreaOutput.setText(result);
        highlightText(text, regex);
    }

    private void highlightText(String text, String regex) {
        textFlowOutput.getChildren().clear();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int lastEnd = 0;
        while (matcher.find()) {
            if (matcher.start() > lastEnd) {
                textFlowOutput.getChildren().add(new Text(text.substring(lastEnd, matcher.start())));
            }
            Text highlightedText = new Text(text.substring(matcher.start(), matcher.end()));
            highlightedText.setStyle("-fx-fill: yellow; -fx-font-weight: bold;");
            textFlowOutput.getChildren().add(highlightedText);
            lastEnd = matcher.end();
        }
        if (lastEnd < text.length()) {
            textFlowOutput.getChildren().add(new Text(text.substring(lastEnd)));
        }
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
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/abudu/test/testprocessingtool/dashboard.fxml")));
                Stage stage = (Stage) toggleButton.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.setTitle("Data Management Dashboard");
            } catch (IOException e) {
                LoggerUtility.logError(e);
            }
        } else {
            titleLabel.setText("Text Processing Tool");
            toggleButton.setText("Switch to Data Management Tool");
        }
    }

    @FXML
    public void handleImport(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(selectedFile.toURI())));
                textAreaInput.setText(content);
            } catch (IOException e) {
                LoggerUtility.logError(e);
                AlertUtility.showErrorAlert("File Error", "Could not read file", "An error occurred while reading the file.");
            }
        }
    }
}