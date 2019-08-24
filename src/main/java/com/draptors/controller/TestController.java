package com.draptors.controller;

import com.draptors.domain.TestEntity;
import com.draptors.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    TestRepository testRepository;

    @RequestMapping("/testDetails")
    @ResponseBody
    public Object testDetails() {
        return testRepository.findAll();
    }
}
