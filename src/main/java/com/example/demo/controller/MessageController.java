package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return repository.save(message);
    }

    // @GetMapping
    @GetMapping(produces = "application/json")
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    // @GetMapping("/server")
    // public string helloServer(){
    //     return "hey server is running";
    // }
}
