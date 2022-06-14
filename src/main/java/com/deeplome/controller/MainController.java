package com.deeplome.controller;

import com.deeplome.DBHandler;
import com.deeplome.entity.Answer;
import com.deeplome.entity.Test;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MainController extends AbstractController implements Initializable {

    @FXML
    private VBox startTestVBox;

    @FXML
    private Text resultText;

    @FXML
    private Button startButton;

    @FXML
    private VBox mainScene;

    @FXML
    private HBox questionSection;

    @FXML
    private Label numberLabel;

    @FXML
    private VBox questionBodyBox;

    @FXML
    private Label textLabel;

    @FXML
    private ImageView questionImage;

    @FXML
    private Label timeLabel;

    @FXML
    private GridPane answersGrid;

    @FXML
    private RadioButton radioButtonFirstAnswer;

    @FXML
    private ToggleGroup answersRadioButtonsGroup;

    @FXML
    private RadioButton radioButtonSecondAnswer;

    @FXML
    private RadioButton radioButtonThirdAnswer;

    @FXML
    private RadioButton radioButtonFourthAnswer;

    @FXML
    private Button answerButton;

    private TimerTask timer = new TimerTask() {
        @Override
        public void run() {

        }

    };
    private List<RadioButton> answersButtons = new ArrayList<>();
    private List<Test> tests = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private DBHandler dbHandler = new DBHandler();
    List<Answer> currentAnswers = new ArrayList<>();

    /**
     * here are declarations of variables:
     * counter - test counter that starts at 0
     * currentQuestion - test id from database
     * correctAnswersCounter - counter of correct answers that gave the user
     * correctAnswer - correct answer's id from database
     */
    private static int counter = 0;
    private static int currentQuestion;
    private static int correctAnswersCounter = 0;

    @FXML
    protected void handleStartButtonAction() throws IOException {
        counter = 0;
        correctAnswersCounter = 0;
        booleanProperties.get("TEST_STARTED").setValue(true);
        tests = dbHandler.getTests().stream().sorted(Comparator.comparingInt(Test::getId)).toList();
        answers = dbHandler.getAnswers(tests).stream().sorted(Comparator.comparingInt(Answer::getTestId)).toList();

        currentQuestion = tests.get(0).getId();
        showTest();
        updateAnswers();
    }

    @FXML
    void handleAnswerButton() {

        int selectedOption;
        switch (((RadioButton) answersRadioButtonsGroup.getSelectedToggle()).getId()) {
            case "radioButtonFirstAnswer" -> selectedOption = 1;
            case "radioButtonSecondAnswer" -> selectedOption = 2;
            case "radioButtonThirdAnswer" -> selectedOption = 3;
            case "radioButtonFourthAnswer" -> selectedOption = 4;
            default -> selectedOption = 0;
        }

        currentQuestion = tests.get(counter).getId();

        if (currentAnswers.get(selectedOption - 1).isCorrect()) {
            correctAnswersCounter++;
        }

        answersRadioButtonsGroup.selectToggle(null);
        counter++;
        if (counter >= 20) {
            finishTest();

        } else {
            showTest();
            updateAnswers();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        booleanProperties.put("TEST_STARTED", new SimpleBooleanProperty(false));
//        startButton.visibleProperty().bind(booleanProperties.get("TEST_STARTED").not());
//        questionSection.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
//        answersGrid.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
//        answerButton.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
//        questionImage.fitWidthProperty().bind(questionBodyBox.widthProperty());
        startTestVBox.visibleProperty().bind(booleanProperties.get("TEST_STARTED").not());
        mainScene.visibleProperty().bind(booleanProperties.get("TEST_STARTED"));
        answersButtons.add(radioButtonFirstAnswer);
        answersButtons.add(radioButtonSecondAnswer);
        answersButtons.add(radioButtonThirdAnswer);
        answersButtons.add(radioButtonFourthAnswer);
    }

    private void updateAnswers() {
        currentAnswers = answers.stream().filter(answer -> answer.getTestId() == currentQuestion).toList();

        for (int i = 0; i < answersButtons.size(); i++) {
            try {
                answersButtons.get(i).setText(i + 1 + ". " + currentAnswers.get(i).getText());
                answersButtons.get(i).setVisible(true);
            } catch (IndexOutOfBoundsException e) {
                answersButtons.get(i).setVisible(false);
            }
        }

//        correctAnswer = currentAnswers.stream().filter(Answer::isCorrect).findFirst().get().getId();
    }

    private void showTest() {
        numberLabel.setText(counter + 1 + "/20");
        questionImage.setImage(new Image(new ByteArrayInputStream(tests.get(counter).getImage())));
    }

    private void finishTest() {
        startButton.setText("Почати заново");
        resultText.setText("Ви відповіли на " + correctAnswersCounter + " правильних питань з " + counter);
        booleanProperties.get("TEST_STARTED").setValue(false);
    }
}