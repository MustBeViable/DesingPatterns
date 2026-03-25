import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static final AccessControlService ACCESS_CONTROL_SERVICE = new AccessControlService();

    private final Map<String, Set<String>> permissions = new HashMap<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return ACCESS_CONTROL_SERVICE;
    }

    public void allowAccess(String documentId, String username) {
        permissions
                .computeIfAbsent(documentId, key -> new HashSet<>())
                .add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.containsKey(documentId)
                && permissions.get(documentId).contains(username);
    }
}