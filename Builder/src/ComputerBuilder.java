public interface ComputerBuilder {
    ComputerBuilder buildProcessor();
    ComputerBuilder buildRAM();
    ComputerBuilder buildHardDrive();
    ComputerBuilder buildGraphicsCard();
    ComputerBuilder buildOperatingSystem();
    Computer getComputer();
}