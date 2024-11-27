package abudu.test.testprocessingtool.services;

import abudu.test.testprocessingtool.models.DataItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing data collections.
 * Provides functionality to add, update, delete, and retrieve data items.
 */
public class DataManagementService {

    private final List<DataItem> dataItems; // Collection of data items

    /**
     * Constructor initializes the data collection.
     */
    public DataManagementService() {
        this.dataItems = new ArrayList<>();
    }

    /**
     * Adds a new DataItem to the collection.
     *
     * @param item The DataItem to add.
     * @return
     * @throws IllegalArgumentException if an item with the same ID already exists.
     */
    public boolean addDataItem(DataItem item) {
        if (findById(item.getId()).isPresent()) {
            throw new IllegalArgumentException("An item with the same ID already exists.");
        }
        dataItems.add(item);
        return false;
    }

    /**
     * Updates an existing DataItem in the collection.
     *
     * @param item The updated DataItem.
     * @return
     * @throws IllegalArgumentException if the item does not exist.
     */
    public boolean updateDataItem(DataItem item) {
        Optional<DataItem> existingItem = findById(item.getId());
        if (existingItem.isEmpty()) {
            throw new IllegalArgumentException("No item found with the specified ID.");
        }
        existingItem.get().setName(item.getName());
        existingItem.get().setValue(item.getValue());
        return false;
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
            throw new IllegalArgumentException("No item found with the specified ID.");
        }
        dataItems.remove(item.get());
        return false;
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
