package com.wuubzi.chatbot.Controllers;

import com.wuubzi.chatbot.DTO.Request.AskDTO;
import com.wuubzi.chatbot.DTO.Response.AskResponseDTO;
import com.wuubzi.chatbot.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/ask")
    public ResponseEntity<AskResponseDTO> ask(@RequestBody @Valid AskDTO askDTO) {
        return new ResponseEntity<AskResponseDTO>(chatService.ask(askDTO), HttpStatus.OK);
    }
}
