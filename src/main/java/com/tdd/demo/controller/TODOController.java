package com.tdd.demo.controller;

import com.tdd.demo.model.TODO;
import com.tdd.demo.model.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/todos")
public class TODOController {

    private TODOService todoService;

    @Autowired
    public TODOController( TODOService todoService ) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TODO> listAction() {
        return this.todoService.findAll();
    }
}
