public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Celeron N3450");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(8);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDriveType("SSD");
        computer.setHardDriveSize(256);
    }

    @Override
    public void buildGraphicsCard() {
        // Uses iGPU
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOS("Windows 11 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}