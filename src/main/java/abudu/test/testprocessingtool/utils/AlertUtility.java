package abudu.test.testprocessingtool.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * AlertUtility is a utility class that provides methods for displaying alert dialogs in JavaFX applications.
 * It simplifies the process of showing different types of alerts to the user (information, warning, error).
 */
public class AlertUtility {

    /**
     * Displays an informational alert with a title, header, and message.
     *
     * @param title   The title of the alert dialog.
     * @param header  The header of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    public static void showInfoAlert(String title, String header, String message) {
        showAlert(AlertType.INFORMATION, title, header, message);
    }

    /**
     * Displays a warning alert with a title, header, and message.
     *
     * @param title   The title of the alert dialog.
     * @param header  The header of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    public static void showWarningAlert(String title, String header, String message) {
        showAlert(AlertType.WARNING, title, header, message);
    }

    /**
     * Displays an error alert with a title, header, and message.
     *
     * @param title   The title of the alert dialog.
     * @param header  The header of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    public static void showErrorAlert(String title, String header, String message) {
        showAlert(AlertType.ERROR, title, header, message);
    }

    /**
     * A private method that displays an alert of a specific type with the given details.
     *
     * @param alertType The type of alert (INFORMATION, WARNING, ERROR).
     * @param title     The title of the alert dialog.
     * @param header    The header of the alert dialog.
     * @param message   The message to display in the alert dialog.
     */
    private static void showAlert(AlertType alertType, String title, String header, String message) {
        Alert alert = new Alert(alertType, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(header);

        // Customize the alert dialog
        alert.setResizable(true); // Allow the alert to be resized
        alert.showAndWait();
    }
}