package com.tdd.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vtsutsman on 7/12/17.
 */
public interface TODORepository extends JpaRepository<TODO, Long> {
}
