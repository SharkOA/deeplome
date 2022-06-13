package com.deeplome.service;

import com.deeplome.entity.Test;
import com.deeplome.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getTests(){
        return testRepository.getTests();
    }
}