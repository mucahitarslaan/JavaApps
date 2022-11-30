package com.mucahitarslan.application.rest.todo.dto;

public class ItemSaveDTO {
    private long todoId;
    private String text;

    public long getTodoId() {
        return todoId;
    }

    public void setTodoId(long todoId) {
        this.todoId = todoId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
