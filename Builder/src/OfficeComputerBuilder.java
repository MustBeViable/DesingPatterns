public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public ComputerBuilder buildProcessor() {
        computer.setProcessor("Intel Celeron N3450");
        return this;
    }

    @Override
    public ComputerBuilder buildRAM() {
        computer.setRAM(8);
        return this;
    }

    @Override
    public ComputerBuilder buildHardDrive() {
        computer.setHardDriveType("SSD");
        computer.setHardDriveSize(256);
        return this;
    }

    @Override
    public ComputerBuilder buildGraphicsCard() {
        // Uses iGPU
        return this;
    }

    @Override
    public ComputerBuilder buildOperatingSystem() {
        computer.setOS("Windows 11 Pro");
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}