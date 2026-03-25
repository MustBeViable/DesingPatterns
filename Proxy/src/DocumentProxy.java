import java.time.LocalDateTime;

public class DocumentProxy implements DocumentInterface {
    private final Document realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getContent(User user) {
        boolean allowed = accessControlService.isAllowed(
                realDocument.getDocumentId(),
                user.getUsername()
        );

        if (!allowed) {
            throw new AccessDeniedException(
                    "Access denied for user '" + user.getUsername()
                            + "' to document '" + realDocument.getDocumentId() + "'"
            );
        }

        return realDocument.getContent(user);
    }

    @Override
    public LocalDateTime getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getDocumentId() {
        return realDocument.getDocumentId();
    }
}