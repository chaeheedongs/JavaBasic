package solid.a_srp.warning;

public class WarningComputer {

    public int cpu;
    public int memory;
    public String graphic;

    public WarningComputer(int cpu, int memory, String graphic) {
        this.cpu = cpu;
        this.memory = memory;
        this.graphic = graphic;
    }

    public int getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public String getGraphic() {
        return graphic;
    }

    public void gamming() {
        System.out.println("Do Gamming");
    }

    public void programming() {
        System.out.println("Do Programming");
    }
}
