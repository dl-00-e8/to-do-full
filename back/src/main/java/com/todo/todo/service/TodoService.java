package com.todo.todo.service;

import com.todo.todo.dto.request.PatchTodoReq;
import com.todo.todo.dto.request.PostTodoReq;
import com.todo.todo.dto.response.GetAllTodoRes;
import com.todo.todo.entity.Todo;
import com.todo.todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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

        try {
            todoRepository.save(todo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public List<GetAllTodoRes> getAllTodo() {
        List<GetAllTodoRes> getAllTodoResList = new ArrayList<>();

        try {
            getAllTodoResList = todoRepository.findAll()
                            .stream()
                            .map(GetAllTodoRes::new)
                            .collect(Collectors.toList());
        }
        catch(Exception e) {
            log.error(e.getMessage());
        }

        return getAllTodoResList;
    }

    public Boolean update(PatchTodoReq patchTodoReq) {

        Optional<Todo> todoOptional = todoRepository.findById(patchTodoReq.getId());

        if(!todoOptional.isPresent()) {
            return Boolean.FALSE;
        }

        Todo todo = new Todo(patchTodoReq.getId(), patchTodoReq.getTitle(), patchTodoReq.getStartTime(), patchTodoReq.getFinishTime());
        todoRepository.save(todo);

        return Boolean.TRUE;
    }

    public Boolean delete(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if(!todoOptional.isPresent()) {
            return Boolean.FALSE;
        }

        todoRepository.deleteById(id);

        return Boolean.TRUE;
    }
}
