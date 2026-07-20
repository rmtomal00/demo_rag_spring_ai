package team.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.demo.vectorDb.QdrantRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RagContentManageService {

    private final QdrantRepo qdrantRepo;

    public void saveFileToVector(MultipartFile file) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            String content = sb.toString();
            content = content.replace("\r", "");
            List<String> list = List.of(content.split("\\."));
            var d = new ArrayList<Document>();
            for (String s : list) {
                d.add(
                        Document.builder()
                                .text(s)
                                .metadata("user", 1)
                                .metadata("content", Objects.requireNonNull(file.getOriginalFilename()))
                                .build()
                );
            }
            qdrantRepo.save(d);
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
    }
}
