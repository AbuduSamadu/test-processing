package abudu.test.testprocessingtool.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataItem {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty value;

    public DataItem(String id, String name, String value) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleStringProperty(value);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getValue() {
        return value.get();
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public StringProperty valueProperty() {
        return value;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "id='" + id.get() + '\'' +
                ", name='" + name.get() + '\'' +
                ", value='" + value.get() + '\'' +
                '}';
    }
}