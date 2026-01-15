package components.abstracts;

public abstract class Button extends Element {

    protected Button(String text) {
        super(text);
    }

    @Override
    public abstract void display();
}
