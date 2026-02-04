package observers;

public class ConcreteObserver implements Observer {

    private String name;
    private double temperature;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(double newTemp) {
        this.temperature = newTemp;
        System.out.println(name + " temperature is now: " + temperature);
    }
}
