import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logger {
    static Logger logger;
    static String fileName;
    static StringBuilder data;

    private Logger() {
        data = new StringBuilder();
    }

    public static synchronized Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public synchronized void setFileName(String name) {
        fileName = name;
    }

    public synchronized void write(String text) {
        data.append(text);
        data.append("\n");
    }

    public void close() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(String.valueOf(data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
