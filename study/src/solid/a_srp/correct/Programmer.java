package solid.a_srp.correct;

public class Programmer {

    private CorrectComputer computer;
    private String doSomeThing;

    public Programmer(CorrectComputer computer, String doSomeThing) {
        this.computer = computer;
        this.doSomeThing = doSomeThing;
    }

    public void work() {
        System.out.println("do " + doSomeThing);
    }
}
