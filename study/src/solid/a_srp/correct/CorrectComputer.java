package solid.a_srp.correct;

public class CorrectComputer {

    public int cpu;
    public int memory;
    public String graphic;

    public CorrectComputer(int cpu, int memory, String graphic) {
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

    public void info() {
        System.out.println("info {" +
                "cpu=" + this.cpu +
                ", memory=" + this.memory +
                ", graphic='" + this.graphic + '\'' +
                '}');
    }
}
