package com.todo.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("to-do")
public class TodoController {

    @PostMapping("/register")
    public ResponseEntity<String> registerTodo() {

        return ResponseEntity.ok("Post Success");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateTodo() {

        return ResponseEntity.ok("Patch Success");
    }

    @DeleteMapping("/delete/{todo_id}")
    public ResponseEntity<String> deleteTodo() {

        return ResponseEntity.ok("Delete Success");
    }

    @GetMapping("/list")
    public ResponseEntity<String> getAllTodo() {

        return ResponseEntity.ok("Post Success");
    }
}
