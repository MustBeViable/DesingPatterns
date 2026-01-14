package components.concrete.a;

import components.abstracts.Button;
import components.abstracts.Checkbox;
import components.abstracts.TextField;
import components.abstracts.UIFactory;

public class AFactory extends UIFactory {
    private final char uniqueMarker = '-';

    @Override
    protected Button createButton(String text) {
        return new ButtonA(text, uniqueMarker);
    }

    @Override
    protected TextField createTextField(String text) {
        return new TextFieldA(text, uniqueMarker);
    }

    @Override
    protected Checkbox createCheckbox(String text) {
        return new CheckboxA(uniqueMarker);
    }
}
