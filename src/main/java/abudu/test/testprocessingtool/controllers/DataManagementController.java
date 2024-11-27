package abudu.test.testprocessingtool.controllers;

import abudu.test.testprocessingtool.models.DataItem;
import abudu.test.testprocessingtool.services.DataManagementService;
import abudu.test.testprocessingtool.utils.AlertUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.List;

/**
 * Controller for managing data items using JavaFX.
 * Provides functionality for adding, updating, deleting, and displaying data items.
 */
public class DataManagementController {

    @FXML
    private TextField itemIdField;

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemValueField;

    @FXML
    private Button addItemButton;

    @FXML
    private Button updateItemButton;

    @FXML
    private Button deleteItemButton;

    @FXML
    private TableView<DataItem> dataTable;

    @FXML
    private TableColumn<DataItem, String> idColumn;

    @FXML
    private TableColumn<DataItem, String> nameColumn;

    @FXML
    private TableColumn<DataItem, String> valueColumn;

    private final DataManagementService dataManagementService = new DataManagementService();
    private final ObservableList<DataItem> observableDataList = FXCollections.observableArrayList();

    /**
     * Initializes the controller and sets up the table columns.
     */
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty());
        dataTable.setItems(observableDataList);
        loadData();
    }

    /**
     * Loads all data items from the service and updates the table view.
     */
    private void loadData() {
        List<DataItem> items = dataManagementService.getAllDataItems();
        observableDataList.setAll(items);
    }

    /**
     * Handles the event to add a new data item.
     */
    @FXML
    public void handleAddItem() {
        String id = itemIdField.getText();
        String name = itemNameField.getText();
        String value = itemValueField.getText();

        if (id.isEmpty() || name.isEmpty() || value.isEmpty()) {
            AlertUtility.showErrorAlert("Validation Error", "All fields are required to add an item.", "Please fill in all fields.");
            return;
        }

        DataItem newItem = new DataItem(id, name, value);
        if (dataManagementService.addDataItem(newItem)) {
            observableDataList.add(newItem);
            clearFields();
            AlertUtility.showInfoAlert("Success", "Item added successfully.", "The new item has been added.");
        } else {
            AlertUtility.showErrorAlert("Error", "An item with the same ID already exists.", "Please use a different ID.");
        }
    }

    /**
     * Handles the event to update an existing data item.
     */
    @FXML
    public void handleUpdateItem() {
        String id = itemIdField.getText();
        String name = itemNameField.getText();
        String value = itemValueField.getText();

        if (id.isEmpty() || name.isEmpty() || value.isEmpty()) {
            AlertUtility.showErrorAlert("Validation Error", "All fields are required to update an item.", "Please fill in all fields.");
            return;
        }

        DataItem updatedItem = new DataItem(id, name, value);
        if (dataManagementService.updateDataItem(updatedItem)) {
            loadData();
            clearFields();
            AlertUtility.showInfoAlert("Success", "Item updated successfully.", "The updated item has been updated.");
        } else {
            AlertUtility.showErrorAlert("Error", "Item not found or update failed.", "Please check the item ID and try again.");
        }
    }

    /**
     * Handles the event to delete the selected data item.
     */
    @FXML
    public void handleDeleteItem() {
        DataItem selectedItem = dataTable.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            AlertUtility.showErrorAlert("Selection Error", "Please select an item to delete.", "Please select an item to delete.");
            return;
        }

        if (dataManagementService.deleteDataItem(selectedItem.getId())) {
            observableDataList.remove(selectedItem);
            clearFields();
            AlertUtility.showInfoAlert("Success", "Item deleted successfully.", "The selected item has been deleted.");
        } else {
            AlertUtility.showErrorAlert("Error", "Item deletion failed.", "Please try again.");
        }
    }

    /**
     * Handles the event to populate fields when a row in the table is selected.
     *
     * @param event The mouse event triggered by selecting a table row.
     */
    @FXML
    public void handleRowSelection(MouseEvent event) {
        DataItem selectedItem = dataTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            itemIdField.setText(selectedItem.getId());
            itemNameField.setText(selectedItem.getName());
            itemValueField.setText(selectedItem.getValue());
        }
    }

    /**
     * Clears all input fields.
     */
    private void clearFields() {
        itemIdField.clear();
        itemNameField.clear();
        itemValueField.clear();
    }
}