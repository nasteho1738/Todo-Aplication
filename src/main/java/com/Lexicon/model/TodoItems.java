package com.Lexicon.model;

public class TodoItems {
    private int todoId;
    private int assigneeId;
    private String title;
    private String description;
    private String deadline;
    private boolean done;

    public TodoItems(int todoId, int assigneeId, String title, String description, String deadline, boolean done) {
        this.todoId = todoId;
        this.assigneeId = assigneeId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItems{" +
                "todoId=" + todoId +
                ", assigneeId=" + assigneeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", done=" + done +
                '}';
    }
}
