package com.tdd.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vitaliy on 7/11/17.
 */
@Service
public class TODOServiceImpl implements TODOService {

    @Autowired
    private TODORepository todoRepository;

    @Override
    public List<TODO> findAll() {
        return this.todoRepository.findAll();
    }
}
