package com.todo.todo.dto.response;

import com.todo.todo.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GetAllTodoRes {

    private Long id;

    private String title;

    private LocalDate startTime;

    private LocalDate finishTime;

    public GetAllTodoRes(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.startTime = todo.getStartTime();
        this.finishTime = todo.getFinishTime();
    }
}
