package components.abstracts;

public abstract class Checkbox extends Element {
    protected Checkbox(String text) {
        super(text);
    }

    @Override
    public abstract void display();
}
