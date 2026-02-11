public class EncryptedPrinter extends PrinterDecorator {
    private static final int SHIFT = 3; // kuinka monta merkkiä siirretään

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String input) {
        super.print(encrypt(input));
    }

    private String encrypt(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 32 && c <= 126) {
                char encryptedChar = (char) (c + SHIFT);
                result.append(encryptedChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

}
