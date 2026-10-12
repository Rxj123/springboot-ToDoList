package com.example.todolist.controller;



import com.example.todolist.model.Todo;

import com.example.todolist.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



import java.util.List;



@RestController

@RequestMapping("/api/todos")

public class TodoController {

    @Autowired

    private TodoService todoService;



    @GetMapping

    public ResponseEntity<List<Todo>> getAllTodos() {

        return ResponseEntity.ok(todoService.findAll());

    }



    @PostMapping

    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {

        if (todo.getTitle() == null || todo.getTitle().trim().isEmpty()) {

            return ResponseEntity.badRequest().build();

        }

        return new ResponseEntity<>(todoService.save(todo), HttpStatus.CREATED);

    }



    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {

        todoService.deleteById(id);

        return ResponseEntity.noContent().build();

    }

}