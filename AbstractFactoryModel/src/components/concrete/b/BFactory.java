package components.concrete.b;

import components.abstracts.Button;
import components.abstracts.Checkbox;
import components.abstracts.TextField;
import components.abstracts.UIFactory;

public class BFactory extends UIFactory {
    private final char uniqueMarker = '~';

    @Override
    protected Button createButton(String text) {
        return new ButtonB(text, uniqueMarker);
    }

    @Override
    protected TextField createTextField(String text) {
        return new TextFieldB(text, uniqueMarker);
    }

    @Override
    protected Checkbox createCheckbox(String text) {
        return new CheckboxB(uniqueMarker);
    }
}
