public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory documents = new Directory("documents");
        Directory images = new Directory("images");
        Directory projects = new Directory("projects");

        MyFile file1 = new MyFile("notes.txt", 1.2);
        MyFile file2 = new MyFile("report.pdf", 3.5);
        MyFile file3 = new MyFile("photo.jpg", 5.7);
        MyFile file4 = new MyFile("diagram.png", 2.4);
        MyFile file5 = new MyFile("program.java", 0.8);
        MyFile file6 = new MyFile("readme.txt", 0.3);

        documents.addElement(file1);
        documents.addElement(file2);

        images.addElement(file3);
        images.addElement(file4);

        projects.addElement(file5);
        projects.addElement(file6);

        root.addElement(documents);
        root.addElement(images);
        root.addElement(projects);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total file size: " + sizeVisitor.getTotalSizeInMb() + " MB");

        SearchVisitor txtSearchVisitor = new SearchVisitor(".txt");
        root.accept(txtSearchVisitor);

        System.out.println("\nMatching .txt files:");
        for (MyFile file : txtSearchVisitor.getMatchingFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSizeInMb() + " MB)");
        }
    }
}