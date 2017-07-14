package com.tdd.demo.controller;

import com.tdd.demo.model.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TODOController {

    private TODOService todoService;

    @Autowired
    public TODOController(TODOService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List listAction() {
        return this.todoService.findAll();
    }
}
