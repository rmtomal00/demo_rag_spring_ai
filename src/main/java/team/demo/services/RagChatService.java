package team.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import team.demo.vectorDb.QdrantRepo;

@Service
@RequiredArgsConstructor
public class RagChatService {
    final ChatClient chatClient;
    private final QdrantRepo qdrantRepo;

    public String chat(String message) {
        var d = qdrantRepo.query(message);
        if (d == null || d.isEmpty()) {
            return "I don't understand. Please specify your message, What you want to know?";
        }
        StringBuilder content = new StringBuilder();
        for (var qdrant : d) {
            content.append(String.format("%s\n", qdrant.getText()));
        }
        System.out.printf("UserInput context: %s\n", content);

       return chatClient.prompt()
               .system("""
                       Instructions:
                         - Answer only the question.
                         - Do not repeat the context.
                         - Keep the answer short.
                         - You are an SenderX assistance team so that give reply as a SenderX team.
                         - Give reply professionally.
                         - If get any question out of context, Say: I don't know. Please wait a teammate will reply soon.
                       Context:
                        %s
                       """.formatted(content.toString()))
               .user(message)
               .call()
               .content();
    }
}
