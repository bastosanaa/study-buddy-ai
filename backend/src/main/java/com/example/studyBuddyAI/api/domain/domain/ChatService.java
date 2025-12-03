package com.example.studyBuddyAI.api.domain.domain;

import org.springframework.ai.chat.client.ChatClient;

public class ChatService {

    private final ChatClient chatClient;


    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String handleChatPrompt(String userPrompt) {
        return this.chatClient.prompt()
                .user(userPrompt)
                .call()
                .content();
    }
}
