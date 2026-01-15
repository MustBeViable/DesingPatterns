package components.abstracts;

public abstract class TextField extends Element {
    protected TextField(String text) {
        super(text);
    }

    @Override
    public abstract void display();
}
