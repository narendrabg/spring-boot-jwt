package com.example.helloworld.controller;

import com.example.helloworld.dto.Todo;
import com.example.helloworld.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @GetMapping("/jpa/{name}/todos")
    public ResponseEntity<List<Todo>> getAllTodos(@PathVariable String name) {
        return ResponseEntity.ok(todoService.getAllTodos(name));
    }

    @DeleteMapping("/jpa/{name}/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String name,@PathVariable Long id) {
        todoService.deleteTodo(name,id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/jpa/{name}/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String name,@PathVariable Long id) {
        Optional<Todo> optionalTodo =  todoService.getTodoById(name,id);
        return optionalTodo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @PutMapping("/jpa/{name}/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String name, @PathVariable Integer id,@RequestBody
                                           Todo todo) {
        if(todo.getId() ==null || todo.getId() ==-1) {
            todo.setUserName(name);
            Todo createdTodo = todoService.save(todo);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createdTodo.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.ok(todoService.save(todo));
    }

    @PostMapping("/jpa/{name}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String name, @RequestBody Todo todo) {
        todo.setUserName(name);
        Todo createdTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
