module abudu.test.testprocessingtool {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;

    opens abudu.test.testprocessingtool to javafx.fxml;
    opens abudu.test.testprocessingtool.controllers to javafx.fxml;
    exports abudu.test.testprocessingtool;
    exports abudu.test.testprocessingtool.controllers;
}