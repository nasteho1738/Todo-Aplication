package com.Lexicon;

import com.Lexicon.Data.DaoImpl.PersonDaoImpl;
import com.Lexicon.Data.DaoImpl.TodoItemsDaoImpl;
import com.Lexicon.Data.PersonDao;
import com.Lexicon.Data.TodoItemsDao;
import com.Lexicon.model.TodoItems;

import java.sql.Connection;

public class App {

    public static void main(String[] args )
    {
        Connection Connection = null;
        TodoItemsDao todoItemsDao = new TodoItemsDaoImpl(Connection);
            PersonDao personDao = new PersonDaoImpl(Connection);
            TodoItems todo = new TodoItems();
            todo.setTitle("Buy groceries");
            todo.setDescription("Milk, eggs, bread");
            todo.setDone(false);
            TodoItems createdTodo = TodoItems.create(todo);
            System.out.println("Created Todo: " + createdTodo);

        }
    }
