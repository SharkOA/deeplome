package com.deeplome.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class Test implements Serializable {

    private int id;
    private byte[] image;
    private String text;
    private int answersCount;

    public int getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public Test(int id, byte[] image, String text, int answersCount) {
        this.id = id;
        this.image = image;
        this.text = text;
        this.answersCount = answersCount;
    }

}