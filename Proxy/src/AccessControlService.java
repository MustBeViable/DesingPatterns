public class AccessControlService {
    private static AccessControlService accessControlService = new AccessControlService();

    private AccessControlService() {};

    public static AccessControlService getAccessControlService() {
        return accessControlService;
    }

    public boolean isAllowed(Document document, User user) {
        if (Identifier.PUBLIC == document.getIdentifier() || document.getOwnerId() == user.getUserId()) {
            return true;
        } return false;
    }
}
