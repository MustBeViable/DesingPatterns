public class CalendarApp {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(24);
        date.setMonth(3);
        date.setYear(2026);

        System.out.println("Initial date: "
                + date.getDay() + "."
                + date.getMonth() + "."
                + date.getYear());

        date.advanceDays(7);
        System.out.println("After 7 days: "
                + date.getDay() + "."
                + date.getMonth() + "."
                + date.getYear());

        date.advanceDays(30);
        System.out.println("After 30 more days: "
                + date.getDay() + "."
                + date.getMonth() + "."
                + date.getYear());
    }
}