package components.concrete.b;

import components.abstracts.Checkbox;

public class CheckboxB extends Checkbox {

    private final char text = 'X';
    private final char uniqueMarker;

    CheckboxB(char uniqueMarker) {
        this.uniqueMarker = uniqueMarker;
    }
    @Override
    public void display() {
        System.out.print("*");
        for (int i = 0; i < 3; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");

        System.out.printf("|%c|\n", this.text);

        System.out.print("*");
        for (int i = 0; i < 10; i++) {
            System.out.print(this.uniqueMarker);
        }
        System.out.print("*\n");
    }
}
