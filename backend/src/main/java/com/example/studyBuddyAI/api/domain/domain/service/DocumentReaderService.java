package com.example.studyBuddyAI.api.domain.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentReaderService {

    private final VectorStore vectorStore;

    public void storeDocumentVector(Resource resource) { //multi responsabilidade

        var reader = new TikaDocumentReader(resource);
        var documents = reader.get();

        var splitter = new TokenTextSplitter();
        var splitDocuments = splitter.apply(documents);

        vectorStore.add(splitDocuments);
    }
}
