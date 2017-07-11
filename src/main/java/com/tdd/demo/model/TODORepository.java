package com.tdd.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TODORepository extends JpaRepository<TODO, Long> {
}
