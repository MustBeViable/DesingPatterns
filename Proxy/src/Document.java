import java.time.LocalDateTime;

public class Document implements DocumentInterface {
    private final String documentId;
    private final LocalDateTime creationDate;
    private final String content;

    public Document(String documentId, String content) {
        this.documentId = documentId;
        this.content = content;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String getDocumentId() {
        return documentId;
    }
}