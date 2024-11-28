package abudu.test.testprocessingtool.services;

import abudu.test.testprocessingtool.models.DataItem;
import abudu.test.testprocessingtool.utils.AlertUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing data collections.
 * Provides functionality to add, update, delete, and retrieve data items.
 */
public class DataManagementService {

    private final List<DataItem> dataItems;


    /**
     * Constructor initializes the data collection.
     */
    public DataManagementService() {
        this.dataItems = new ArrayList<>();

    }

    // Add a new data item to the collection
    public boolean addDataItem(DataItem item) {
        if (findById(item.getId()).isPresent()) {
            AlertUtility.showErrorAlert("Error", "Item already exists.", "Please provide a unique item ID.");
            return false;
        }
        dataItems.add(item);
        return true;
    }

    // Update an existing data item in the collection
    public boolean updateDataItem(DataItem item) {
        Optional<DataItem> existingItem = findById(item.getId());
        if (existingItem.isEmpty()) {
            AlertUtility.showErrorAlert("Error", "Item not found or update failed.", "Please check the item ID and try again.");
            return false;
        }
        existingItem.get().setName(item.getName());
        existingItem.get().setValue(item.getValue());
        return true;
    }

    /**
     * Deletes a DataItem from the collection by ID.
     *
     * @param id The ID of the DataItem to delete.
     * @throws IllegalArgumentException if no item is found with the specified ID.
     */
    public boolean deleteDataItem(String id) {
        Optional<DataItem> item = findById(id);
        if (item.isEmpty()) {
            AlertUtility.showErrorAlert("Error", "Item not found or delete failed.", "Please check the item ID and try again.");
            return false;
        }
        dataItems.remove(item.get());
        return true;
    }

    /**
     * Retrieves all DataItems from the collection.
     *
     * @return A list of all DataItems.
     */
    public List<DataItem> getAllDataItems() {
        return new ArrayList<>(dataItems);
    }

    /**
     * Finds a DataItem by its ID.
     *
     * @param id The ID of the DataItem to find.
     * @return An Optional containing the DataItem if found, or an empty Optional.
     */
    private Optional<DataItem> findById(String id) {
        return dataItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
