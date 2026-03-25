public class MyFile implements FileSystemElement {
    private final String name;
    private final double sizeInMb;

    public MyFile(String name, double sizeInMb) {
        this.name = name;
        this.sizeInMb = sizeInMb;
    }

    public double getSizeInMb() {
        return sizeInMb;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}