package com.tdd.demo;

import com.tdd.demo.model.TODORepository;
import com.tdd.demo.model.TODOService;
import com.tdd.demo.model.TODOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vitaliy on 7/11/17.
 */
@RunWith( MockitoJUnitRunner.class )
public class TODOServiceTest {

    @Mock
    private TODORepository todoRepository;

    @InjectMocks
    private TODOService todoService = new TODOServiceImpl();

    @Test
    public void testFindAll() {

        when(this.todoRepository.findAll()).thenReturn( new ArrayList<>(  ) );

        todoService.findAll();

        verify( this.todoRepository, times( 1 ) ).findAll();
    }
}
