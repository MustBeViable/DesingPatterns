public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
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
        computer.setGPU("NVIDIA RTX 4080");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOS("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}