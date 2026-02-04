import observers.ConcreteObserver;
import observers.Observer;
import subjects.Subject;
import subjects.WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Observer> obslist = new ArrayList<>();

        obslist.add(new ConcreteObserver("obs1"));
        obslist.add(new ConcreteObserver("obs2"));
        obslist.add(new ConcreteObserver("obs3"));
        obslist.add(new ConcreteObserver("obs4"));
        obslist.add(new ConcreteObserver("obs5"));

        Subject weatherStation = new WeatherStation();

        for (Observer obs : obslist) {
            weatherStation.attach(obs);
        }

        Thread stationThread = new Thread(weatherStation);

        stationThread.start();

    }
}
