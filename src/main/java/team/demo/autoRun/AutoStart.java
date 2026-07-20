package team.demo.autoRun;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import team.demo.services.RagChatService;
import team.demo.vectorDb.QdrantRepo;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AutoStart implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    }
}
