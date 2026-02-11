public class Main {
    public static void main(String[] args) {
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World!");

        Printer printer2 =  new XMLPrinter(new EncryptedPrinter(new XMLPrinter(new BasicPrinter())));
        printer2.print("Hello World!");

    }
}
