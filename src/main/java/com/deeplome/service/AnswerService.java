package com.deeplome.service;

import com.deeplome.entity.Answer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("answerService")
public interface AnswerService {
    List<Answer> getAnswers(List<Integer> tests);
}