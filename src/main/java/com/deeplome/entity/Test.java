package com.deeplome.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private byte[] image;

    private String text;

    @Column(name = "answers_count")
    private int answersCount;

    public Test(int id, byte[] image, String text, int answersCount) {
        this.id = id;
        this.image = image;
        this.text = text;
        this.answersCount = answersCount;
    }

//    @OneToMany
//    private List<Answer> answers;

}