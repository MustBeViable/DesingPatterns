package components.abstracts;

public abstract class UIFactory {

    public Element[] generate(String text) {
        Element[] array = new Element[3];
        array[0] = this.createButton(text);
        array[1] = this.createCheckbox(text);
        array[2] = this.createTextField(text);
        return array;
    }

    protected abstract Button createButton(String text);
    protected abstract TextField createTextField(String text);
    protected abstract Checkbox createCheckbox(String text);
}
