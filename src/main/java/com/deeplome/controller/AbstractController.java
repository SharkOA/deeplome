package com.deeplome.controller;

import com.deeplome.service.AnswerService;
import com.deeplome.service.TestService;
import javafx.beans.property.BooleanProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractController {

    @Autowired
    protected TestService testService;

    @Autowired
    protected AnswerService answerService;

    public static Map<String, BooleanProperty> booleanProperties = new ConcurrentHashMap<>();

}
