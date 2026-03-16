package memento.guistate;

public class Memento implements IMemento {
    private final int[] options;
    private final boolean isSelected;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone();
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getDescription() {
        return "History";
    }
}
