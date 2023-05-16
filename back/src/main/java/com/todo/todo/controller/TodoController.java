package com.todo.todo.controller;

import com.todo.todo.dto.request.PatchTodoReq;
import com.todo.todo.dto.request.PostTodoReq;
import com.todo.todo.dto.response.GetAllTodoRes;
import com.todo.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

        log.info("Post Start");

        // Validation


        // Business Logic
        todoService.register(postTodoReq);

        // Make Response
        String response = "Post Success";
        log.info("result = ", response);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateTodo(@RequestBody PatchTodoReq patchTodoReq) {

        log.info("Patch Start");

        // Validation


        // Business Logic
        Boolean check = todoService.update(patchTodoReq);

        // Make Response
        String response = "Patch Success";
        if(check == Boolean.FALSE) {
            response = "Patch failed";
            log.info("result = ", response);
            return ResponseEntity.badRequest().build();
        }
        log.info("result = ", response);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{todo_id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("todo_id") Long id) {

        // Validation


        // Business Logic
        Boolean check = todoService.delete(id);

        // Make Response
        String response = "Delete Success";
        if(check == Boolean.FALSE) {
            response = "Delete Failed";
            log.info("result = ", response);
            return ResponseEntity.badRequest().build();
        }

        log.info("result = ", response);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<GetAllTodoRes>> getAllTodo() {

        // Validation


        // Business Logic
        List<GetAllTodoRes> getAllTodoResList = todoService.getAllTodo();

        // Make Response
        String response = "Delete Success";
        log.info("result = ", response);

        return ResponseEntity.ok(getAllTodoResList);
    }
}
