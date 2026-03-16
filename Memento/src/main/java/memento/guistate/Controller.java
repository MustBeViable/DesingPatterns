package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Model model;
    private final Gui gui;
    private final List<IMemento> history;
    private final List<IMemento> future;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.future = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        clearFuture();
        model.setOption(optionNumber, choice);

    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        clearFuture();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            saveToFuture();
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!future.isEmpty()) {
            saveToHistory();
            System.out.println("Memento found in the future");
            IMemento nextState = future.remove(future.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void saveToFuture() {
        IMemento currentState = model.createMemento();
        future.add(currentState);
    }

    public List<IMemento> showHistory() {
        return history;
    }

    public void restoreFromHistory(int index) {
        if (index < 0 || index >= history.size()) {
            return;
        }

        IMemento selectedState = history.get(index);

        saveToFuture();

        while (history.size() > index + 1) {
            future.add(history.remove(history.size() - 1));
        }

        model.restoreState(selectedState);
        gui.updateGui();
    }

    public void clearFuture() {
        future.clear();
    }
}

