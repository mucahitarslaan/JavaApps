package com.mucahitarslan.application.rest.todo.data.entity;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todoappdb")
@Data
public class Todo{//POJO (Plain Old Java Object)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private long id;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Column(name = "text", length = 512)
    private String text;

    @Column(name = "instert_date_time", nullable = false)
    private LocalDateTime insertDateTime = LocalDateTime.now();

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate = insertDateTime;

    @Column(name = "completed", nullable = false)
    private boolean completed;



}
