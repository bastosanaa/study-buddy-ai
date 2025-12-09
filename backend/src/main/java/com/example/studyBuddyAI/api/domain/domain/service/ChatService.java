package com.example.studyBuddyAI.api.domain.domain.service;

import com.example.studyBuddyAI.api.domain.domain.PromptTemplates;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public String handleChatPrompt(String userPrompt) {


        List<Document> similarDocuments = retrieveSimilarDocuments(userPrompt);

        if (similarDocuments.isEmpty()) {
            return PromptTemplates.NO_INFO_FOUND; //TODO: Tratamento de erros personalizados
        }

        String context = augmentContext(similarDocuments);

        return generateAnswer(userPrompt, context);
    }

    private List<Document> retrieveSimilarDocuments(String searchRequest) {
        return  vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(searchRequest)
                        .topK(3)
                        .build()
        );
    }

    private String augmentContext(List<Document> documents) {
        return documents.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));
    }

    private String generateAnswer(String userPrompt , String context) {

        String systemMessage = PromptTemplates.STUDY_BUDDY_SYSTEM.formatted(context);

        return chatClient.prompt()
                .system(systemMessage)
                .user(userPrompt)
                .call()
                .content();
    }
}
