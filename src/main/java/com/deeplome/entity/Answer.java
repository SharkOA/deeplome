package com.deeplome.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_correct")
    private boolean isCorrect;

    private byte[] image;

    private String text;

//    @ManyToOne
//    @JoinColumn(name = "test_id")
    private int test;

    public Answer(int id, boolean isCorrect, byte[] image, String text, int test) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.image = image;
        this.text = text;
        this.test = test;
    }
}
