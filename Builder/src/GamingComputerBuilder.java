public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public ComputerBuilder buildProcessor() {
        computer.setProcessor("Amd Ryzen 19 199090X4D");
        return this;
    }

    @Override
    public ComputerBuilder buildRAM() {
        computer.setRAM(32);
        return this;
    }

    @Override
    public ComputerBuilder buildHardDrive() {
        computer.setHardDriveType("SSD");
        computer.setHardDriveSize(2000);
        return this;
    }

    @Override
    public ComputerBuilder buildGraphicsCard() {
        computer.setGPU("NVIDIA RTX 6090 ti super");
        return this;
    }

    @Override
    public ComputerBuilder buildOperatingSystem() {
        computer.setOS("Temple OS");
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}