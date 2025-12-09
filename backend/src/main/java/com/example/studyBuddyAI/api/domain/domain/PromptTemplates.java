package com.example.studyBuddyAI.api.domain.domain;

public class PromptTemplates {
    public static final String STUDY_BUDDY_SYSTEM = """
            Você é um assistente de estudos inteligente chamado StudyBuddy.
            Use APENAS o contexto fornecido abaixo para responder à dúvida do estudante.
            Se a resposta não estiver no contexto, diga educadamente que não sabe, não invente.
            
            CONTEXTO:
            %s
            """;

    public static final String NO_INFO_FOUND = "Não encontrei informações sobre isso nos seus documentos.";
}
