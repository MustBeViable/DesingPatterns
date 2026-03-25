import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents = new HashMap<>();

    public void addUnprotectedDocument(String documentId, String content) {
        Document document = new Document(documentId, content);
        documents.put(documentId, document);
    }

    public void addProtectedDocument(String documentId, String content, String... allowedUsers) {
        Document realDocument = new Document(documentId, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);

        AccessControlService accessControlService = AccessControlService.getInstance();
        for (String username : allowedUsers) {
            accessControlService.allowAccess(documentId, username);
        }

        documents.put(documentId, proxy);
    }

    public DocumentInterface getDocument(String documentId) {
        return documents.get(documentId);
    }
}