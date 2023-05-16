package com.todo.todo.entity;

import com.todo.todo.constant.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "started_at")
    private LocalDate startTime;

    @Column(name = "finished_at")
    private LocalDate finishTime;

    @Builder
    public Todo(String title, LocalDate startTime, LocalDate finishTime) {
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
}
