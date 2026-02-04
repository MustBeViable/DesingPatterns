package subjects;

import observers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements Runnable {

    private List<Observer> observerList;

    protected Subject() {
        this.observerList = new ArrayList<>();
    }

    public void attach(Observer observer) {
        this.observerList.add(observer);
    };

    public void detach(Observer observer) {
        this.observerList.remove(observer);
    };

    void notifyMethod(double newTemp) {
        for (Observer ob : observerList) {
            ob.update(newTemp);
        }
    };
}
