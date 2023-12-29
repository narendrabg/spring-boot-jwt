package com.example.helloworld.service;

import com.example.helloworld.dto.Todo;
import com.example.helloworld.repository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoJpaRepository todoJpaRepository;
private static int idCounter=0;
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(++idCounter,"Learn to Dance","naren",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn to Drive","naren",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn Angular","naren",new Date(),false));
    }
    public List<Todo> getAllTodos(String name) {

        return todoJpaRepository.findByUserName(name);
    }

    public void deleteTodo(String userName,Long id) {

        todoJpaRepository.deleteById(id);
    }

    public Optional<Todo> getTodoById(String userName, Long id) {
        return todoJpaRepository.findById(id);
    }

    public Todo save(Todo todo) {
//        if(todo.getId()==null || todo.getId()==-1 || todo.getId()==0) {
//            todo.setId(++idCounter);
//            todos.add(todo);
//        } else {
//            deleteTodo("",todo.getId());
//            todos.add(todo);
//        }
        todoJpaRepository.save(todo);
        return todo;
    }
}
