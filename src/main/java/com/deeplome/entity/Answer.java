package com.deeplome.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Answer {


    private int id;
    private boolean isCorrect;
    private byte[] image;
    private String text;
    private int testId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public Answer() {
    }

    public Answer(int id, boolean isCorrect, byte[] image, String text, int testId) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.image = image;
        this.text = text;
        this.testId = testId;
    }
}
