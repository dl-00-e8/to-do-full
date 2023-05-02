package com.todo.todo.entity;

import com.todo.todo.constant.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@NoArgsConstructor
public class Todo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "started_at")
    private LocalDateTime startTime;

    @Column(name = "finished_at")
    private LocalDateTime finishTime;

    @Builder
    public Todo(String title, LocalDateTime startTime, LocalDateTime finishTime) {
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
}
