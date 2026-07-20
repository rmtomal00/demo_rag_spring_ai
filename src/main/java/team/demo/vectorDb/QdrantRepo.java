package team.demo.vectorDb;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QdrantRepo {

    private final QdrantVectorStore vectorStore;

    public void save(List<Document> list) {
        vectorStore.add(list);
    }

    public List<Document> query(String document) {
        SearchRequest request = SearchRequest.builder()
                .query(document)
                .topK(5)
                .similarityThreshold(0.60)
                .build();
        return vectorStore.similaritySearch(request);
    }
}
