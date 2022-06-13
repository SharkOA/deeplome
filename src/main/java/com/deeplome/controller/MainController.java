package com.deeplome.controller;

import com.deeplome.entity.Test;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController extends AbstractController implements Initializable {

    @FXML
    private HBox questionSection;

    @FXML
    private Label numberLabel;

    @FXML
    private Label textLabel;

    @FXML
    private ImageView image;

    @FXML
    private Label timeLabel;

    @FXML
    private Button startButton;

    @FXML
    private GridPane answersGrid;

    @FXML
    private Button answerButton;

    private List<Test> tests = new ArrayList<>();

    @FXML
    protected void handleStartButtonAction() {
        booleanProperties.get("TEST_STARTED").setValue(true);
        tests = testService.getTests();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        booleanProperties.put("TEST_STARTED", new SimpleBooleanProperty(false));
        startButton.visibleProperty().bind(booleanProperties.get("TEST_STARTED").not());
        questionSection.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
        answersGrid.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
        answerButton.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
    }

}