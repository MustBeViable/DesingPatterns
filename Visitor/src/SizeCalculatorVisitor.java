public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSizeInMb = 0;

    @Override
    public void visit(MyFile file) {
        totalSizeInMb += file.getSizeInMb();
    }

    @Override
    public void visit(Directory directory) {
        // Ei lisätä kokoa tässä, koska vain tiedostoilla on koko
    }

    public double getTotalSizeInMb() {
        return totalSizeInMb;
    }
}