package com.deeplome.service;

import com.deeplome.entity.Test;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("testService")
public interface TestService {
    List<Test> getTests();
}
