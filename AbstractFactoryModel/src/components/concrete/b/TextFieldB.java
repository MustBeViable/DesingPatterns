package components.concrete.b;

import components.abstracts.TextField;

public class TextFieldB extends TextField {

    private final String text;
    private final char uniqueMarker;

    TextFieldB(String text, char uniqueMarker) {
        this.text = text;
        this.uniqueMarker = uniqueMarker;
    }
    @Override
    public void display() {
        System.out.print("*");
        for (int i = 0; i < 10; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");

        System.out.printf("|%s|\n", this.text);

        System.out.print("*");
        for (int i = 0; i < 10; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");
    }

}

