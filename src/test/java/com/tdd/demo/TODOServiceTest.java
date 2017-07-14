package com.tdd.demo;

import com.tdd.demo.model.TODO;
import com.tdd.demo.model.TODORepository;
import com.tdd.demo.model.TODOService;
import com.tdd.demo.model.TODOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vtsutsman on 7/12/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TODOServiceTest {

    @Mock
    private TODORepository todoRepository;

    @InjectMocks
    private TODOService todoService = new TODOServiceImpl();

    @Test
    public void testFindAl() {
        when(this.todoRepository.findAll()).thenReturn(
            Stream.of(new TODO(1L, "TODO")).collect(Collectors.toList())
        );

        this.todoService.findAll();

        verify(this.todoRepository, times(1)).findAll();
    }
}
