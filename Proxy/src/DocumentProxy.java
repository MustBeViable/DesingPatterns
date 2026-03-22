import java.nio.file.AccessDeniedException;

public class DocumentProxy extends Document implements Proxy{

    public DocumentProxy(Identifier identifier, User owner, String data) {
        super(identifier, owner, data);
    }

    @Override
    public String getContent(User user, Document document) {
        if (AccessControlService.getAccessControlService().isAllowed(document, user)) {
            return super.getData();
        }
        throw new AccessDeniedException(null, null, "Access denied");
    }
}
