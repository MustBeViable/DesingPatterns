import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);

        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}