module com.sharko.deeplome {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.deeplome to javafx.fxml;
    exports com.deeplome;
    exports com.deeplome.controllers;
    opens com.deeplome.controllers to javafx.fxml;
}