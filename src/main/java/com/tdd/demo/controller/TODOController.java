package com.tdd.demo.controller;

import com.tdd.demo.model.TODO;
import com.tdd.demo.model.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/todos")
public class TODOController {

    @Autowired
    private TODOService todoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TODO> listAction() {
        return this.todoService.findAll();
    }
}
