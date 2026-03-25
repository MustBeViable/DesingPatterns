import java.time.LocalDateTime;

public interface DocumentInterface {
    String getContent(User user);
    LocalDateTime getCreationDate();
    String getDocumentId();
}