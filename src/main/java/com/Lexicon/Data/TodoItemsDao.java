package com.Lexicon.Data;

import com.Lexicon.model.Person;
import com.Lexicon.model.TodoItems;

import java.util.Collection;
import java.util.Optional;

public interface TodoItemsDao {
    TodoItems create(TodoItems todo);
    Collection<TodoItems> findAll();
    Optional<TodoItems> findById(int id);
    TodoItems findByDoneStatus(boolean doneStatus);
    Collection<TodoItems> findByAssignee(int assigneeId);
    TodoItems findByAssignee(Person assignee);
    Collection<TodoItems> findByUnassignedTodos();
    TodoItems update(TodoItems todo);
    boolean deleteById(int id);




}
