package abudu.test.testprocessingtool.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;



public class AlertUtility {

    public static void showInfoAlert(String title, String header, String message) {
        showAlert(AlertType.INFORMATION, title, header, message);
    }

    public static void showWarningAlert(String title, String header, String message) {
        showAlert(AlertType.WARNING, title, header, message);
    }

    public static void showErrorAlert(String title, String header, String message) {
        showAlert(AlertType.ERROR, title, header, message);
    }


    private static void showAlert(AlertType alertType, String title, String header, String message) {
        Alert alert = new Alert(alertType, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(header);

        // Customize the alert dialog
        alert.setResizable(true); // Allow the alert to be resized
        alert.showAndWait();
    }
}