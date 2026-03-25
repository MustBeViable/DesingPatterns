import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String extension;
    private final List<MyFile> matchingFiles;

    public SearchVisitor(String extension) {
        this.extension = extension;
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(MyFile file) {
        if (file.getName().endsWith(extension)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Hakua ei tehdä kansiolle, vain tiedostoille
    }

    public List<MyFile> getMatchingFiles() {
        return matchingFiles;
    }
}