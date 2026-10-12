package com.example.todolist.service;



import com.example.todolist.model.Todo;

import com.example.todolist.repository.TodoRepository;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;



import java.util.Collections;



import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;



public class TodoServiceTest {

    @Mock

    private TodoRepository todoRepository;



    @InjectMocks

    private TodoService todoService;



    public TodoServiceTest() {

        MockitoAnnotations.openMocks(this);

    }



    @Test

    public void testFindAll() {

        when(todoRepository.findAll()).thenReturn(Collections.singletonList(new Todo()));

        assertEquals(1, todoService.findAll().size());

    }

}