module com.sharko.deeplome {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires lombok;
    requires java.persistence;
    requires spring.context;
    requires spring.beans;
    requires spring.data.commons;
    requires spring.jdbc;
    requires java.sql;

    opens com.deeplome to javafx.fxml;
    exports com.deeplome;
    exports com.deeplome.controller;
    opens com.deeplome.controller to javafx.fxml;
}