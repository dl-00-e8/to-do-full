package com.todo.todo.service;

import com.todo.todo.dto.request.PostTodoReq;
import com.todo.todo.dto.response.GetAllTodoRes;
import com.todo.todo.entity.Todo;
import com.todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void register(PostTodoReq postTodoReq) {
        Todo todo = Todo.builder()
                .title(postTodoReq.getTitle())
                .startTime(postTodoReq.getStartTime())
                .finishTime(postTodoReq.getFinishTime())
                .build();

        todoRepository.save(todo);
    }

    public List<GetAllTodoRes> getAllTodo() {
        List<GetAllTodoRes> getAllTodoResList = todoRepository.findAll()
                .stream()
                .map(GetAllTodoRes::new)
                .collect(Collectors.toList());

        return getAllTodoResList;
    }
}
