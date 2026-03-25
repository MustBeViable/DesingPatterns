public class Computer {
    private String processor;
    private int RAM;
    private String hardDriveType;
    private int hardDriveSize;
    private String GPU;
    private String OS;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHardDriveType(String hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    public void setHardDriveSize(int hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void getComputerInfo() {
        if (processor != null) System.out.println("Processor: " + processor);
        if (RAM > 0) System.out.println("RAM: " + RAM + " GB");
        if (hardDriveType != null && hardDriveSize > 0) {
            System.out.println("Hard drive: " + hardDriveSize + " GB " + hardDriveType);
        }
        if (GPU != null) System.out.println("Graphics card: " + GPU);
        if (OS != null) System.out.println("Operating system: " + OS);
    }
}