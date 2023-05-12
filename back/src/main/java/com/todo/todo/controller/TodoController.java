package com.todo.todo.controller;

import com.todo.todo.dto.request.PostTodoReq;
import com.todo.todo.entity.Todo;
import com.todo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("to-do")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTodo(@RequestBody PostTodoReq postTodoReq) {
        todoService.register(postTodoReq);

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
