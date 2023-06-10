package solid.a_srp.correct;

public class Progammer {

    private CorrectComputer computer;
    private String doSomeThing;

    public Progammer(CorrectComputer computer, String doSomeThing) {
        this.computer = computer;
        this.doSomeThing = doSomeThing;
    }

    public void gamming() {
        System.out.println("do " + doSomeThing);
    }
}
