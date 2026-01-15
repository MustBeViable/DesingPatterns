package components.concrete.a;

import components.abstracts.Checkbox;

public class CheckboxA extends Checkbox {
    private final char uniqueMarker;

    CheckboxA(char uniqueMarker) {
        super("X");
        this.uniqueMarker = uniqueMarker;
    }
    @Override
    public void display() {
        System.out.print("*");
        for (int i = 0; i < 3; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");

        System.out.printf("|%s|\n", super.text);

        System.out.print("*");
        for (int i = 0; i < 3; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");
    }
}
