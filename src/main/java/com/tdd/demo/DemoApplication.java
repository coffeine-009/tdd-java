package com.tdd.demo;

import com.tdd.demo.model.TODO;
import com.tdd.demo.model.TODORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Component
class TDDCLR implements CommandLineRunner {

    @Autowired
    private TODORepository todoRepository;
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        this.todoRepository.save(new TODO(3L, "TODO2"));
    }
}
