public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Amd Ryzen 19 199090X4D");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDriveType("SSD");
        computer.setHardDriveSize(2000);
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGPU("NVIDIA RTX 6090 ti super");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOS("Temple OS");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}