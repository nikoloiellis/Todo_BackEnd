package com.cog.rest.webservices.restfulwebservices.controller;

import com.cog.rest.webservices.restfulwebservices.Service.TodoHardcodedService;
import com.cog.rest.webservices.restfulwebservices.models.Todo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TODOController {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/users/{username}/todos")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Todo> getAllTodos(@PathVariable String username){

        return todoHardcodedService.findAll();
    }



    @DeleteMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoHardcodedService.deleteById(id);
        if(todo!=null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }





    @GetMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Todo getTodos(@PathVariable String username,@PathVariable long id){

        return todoHardcodedService.findById(id);
    }


    @PutMapping("/users/{username}/todos/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){

       Todo todoupdate = todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }



    @PostMapping("/users/{username}/todos")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        Todo createdTodo = todoHardcodedService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return  ResponseEntity.created(uri).build();

    }
}
