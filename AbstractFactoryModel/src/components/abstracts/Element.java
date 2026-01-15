package components.abstracts;

public abstract class Element {
    protected final String text;

    protected Element(String text) {
        this.text = text;
    }

    public abstract void display();
}
