package subjects;

public class WeatherStation extends Subject{

    private double min = -30.0;
    private double max = 25.0;

    private double temperature;

    public WeatherStation() {
        super();
        this.temperature = min + (Math.random() * max);
    }

    @Override
    public void run() {
        while (true) {
            try {
                int plusOrMinus = (int) (Math.random() * 2);
                if (plusOrMinus == 1) {
                    this.temperature++;
                } else {
                    this.temperature--;
                }
                notifyMethod(this.temperature);
            try {
                long sleep = 1000L + (long) (Math.random() * 5000);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
                System.out.println(e + " This is THE way to handle exceptions.");
            }
        }
    }
}
