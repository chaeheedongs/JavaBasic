package solid.a_srp;

import solid.a_srp.correct.CorrectComputer;
import solid.a_srp.correct.Progammer;
import solid.a_srp.correct.Programmer;
import solid.a_srp.warning.WarningComputer;

/**
 * SRP - Single Responsibility Principle : 단일 책임 원칙
 * - 어떤 클래스를 변경해야 하는 이유는 오직 하나뿐이어야 한다. [ 로버트 C. 마틴 ]
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 일단 고성능 PC
         */
        int cpu = 16;
        int memory = 32;
        String graphic = "RTX3090TI";

        WarningComputer warningComputer = new WarningComputer(cpu, memory, graphic);
        System.out.println("============= Warning =============");
        warningComputer.gamming();
        warningComputer.programming();
        System.out.println("===================================");
        System.out.println();


        /**
         * 개발용
         */
        cpu = 8;
        memory = 16;
        graphic = "internal graphic";

        System.out.println("============= Correct =============");
        CorrectComputer programmerComputer = new CorrectComputer(cpu, memory, graphic);
        programmerComputer.info();

        Progammer progammer = new Progammer(programmerComputer, "gamming !");
        progammer.gamming();


        /**
         * 게임용
         */
        cpu = 16;
        memory = 32;
        graphic = "RTX3090TI";

        CorrectComputer progammerComputer = new CorrectComputer(cpu, memory, graphic);
        progammerComputer.info();

        Programmer programmer = new Programmer(progammerComputer, "programming !");
        programmer.work();
        System.out.println("===================================");
        System.out.println();
    }
}
