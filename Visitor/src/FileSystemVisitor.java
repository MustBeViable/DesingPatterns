public interface FileSystemVisitor {
    void visit(MyFile file);
    void visit(Directory directory);
}