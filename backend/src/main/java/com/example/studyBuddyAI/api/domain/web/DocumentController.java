package com.example.studyBuddyAI.api.domain.web;

import com.example.studyBuddyAI.api.domain.domain.service.DocumentReaderService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/document")
public class DocumentController {

    private final DocumentReaderService documentReaderService;

    @PostMapping
    public ResponseEntity<String> addDocument(
           ) {
        var file = new ClassPathResource("teste.pdf");
        System.out.println("❤❤file uploaded" +  file.getFilename()); //TESTE
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Arquivo vazio!"); TESTE
//        }

        try {
            // Converte MultipartFile para Resource (que o Tika aceita)
//            documentReaderService.storeDocumentVector(file.getResource()); TESTE
            documentReaderService.storeDocumentVector(file);
            return ResponseEntity.ok("Ingestão concluída! O arquivo agora faz parte do cérebro da IA.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro na ingestão: " + e.getMessage());
        }
    }
}
