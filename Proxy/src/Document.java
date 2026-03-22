public class Document {
    private String data;
    private Identifier identifier;
    private User owner;

    public Document(Identifier identifier, User owner, String data) {
        this.identifier = identifier;
        this.owner = owner;
        this.data = data;
    }

    protected Identifier getIdentifier() {
        return identifier;
    }


    protected int getOwnerId() {
        return owner.getUserId();
    }

    protected String getData() {
        return this.data;
    }
}
