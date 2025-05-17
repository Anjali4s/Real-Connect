package com.real_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.real_connect.entity.Message;
import com.real_connect.entity.User;
import com.real_connect.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        if (message.getSender() == null || message.getSender().getUserId() == null) {
            return ResponseEntity.badRequest().body("Sender ID is required");
        }
        if (message.getReceiver() == null || message.getReceiver().getUserId() == null) {
            return ResponseEntity.badRequest().body("Receiver ID is required");
        }
        if (message.getContent() == null || message.getContent().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Message content cannot be empty");
        }

        messageService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/inbox")
    public ResponseEntity<List<Message>> getUserInbox(@RequestParam Long receiverId) {
        if (receiverId == null || receiverId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        User receiver = new User();
        receiver.setUserId(receiverId); 

        return ResponseEntity.ok(messageService.getUserInbox(receiver));
    }

}