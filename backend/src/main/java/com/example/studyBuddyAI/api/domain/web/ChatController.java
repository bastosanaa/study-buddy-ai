package com.example.studyBuddyAI.api.domain.web;

import com.example.studyBuddyAI.api.domain.domain.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private ChatService chatService;

    @GetMapping("/ai")
    String generation(String userPrompt) {
        return this.chatService.handleChatPrompt(userPrompt);
    }
}
