public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String input) {
        super.print("<message>" +
                input +
                "</message>");
    }
}
