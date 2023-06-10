package interfaces.impl;

import interfaces.FishBurnMachineDesign;

public class PizzaFishBurnShop implements FishBurnMachineDesign {

    @Override
    public String taste() {
        return "피자";
    }

    @Override
    public int roastTime() {
        return 7; // 굽는 시간
    }

    @Override
    public int firePower() {
        return 5; // 1부터 10까지라면
    }

    @Override
    public int electricityConsumption() {
        return 35; // 7분동안 불의 강도 5로 붕어빵 굽는 기준
    }

    @Override
    public String signatureBurn() {
        return "시그니처 붕어빵";
    }
}
