public class ComputerDirector {

    public void constructComputer(ComputerBuilder builder) {
        builder.buildProcessor()
                .buildRAM()
                .buildHardDrive()
                .buildGraphicsCard()
                .buildOperatingSystem();
        /*
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
         */
    }
}