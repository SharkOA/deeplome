package com.deeplome.service;

import com.deeplome.entity.Answer;
import com.deeplome.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> getAnswers(List<Integer> tests) {
        return answerRepository.getAnswers(tests);
    }
}
