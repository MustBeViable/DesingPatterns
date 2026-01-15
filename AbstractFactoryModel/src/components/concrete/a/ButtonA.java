package components.concrete.a;

import components.abstracts.Button;

public class ButtonA extends Button {
    private final char uniqueMarker;

    ButtonA(String text, char uniqueMarker) {
        super(text);
        this.uniqueMarker = uniqueMarker;
    }
    @Override
    public void display() {
        System.out.print("*");
        for (int i = 0; i < 10; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");

        System.out.printf("|%s|\n", super.text);

        System.out.print("*");
        for (int i = 0; i < 10; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");
    }
}
