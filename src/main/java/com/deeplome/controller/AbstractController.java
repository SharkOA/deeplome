package com.deeplome.controller;

import javafx.beans.property.BooleanProperty;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractController {

    public static Map<String, BooleanProperty> booleanProperties = new ConcurrentHashMap<>();

}
