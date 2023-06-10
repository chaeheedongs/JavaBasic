package interfaces.impl;

import interfaces.FishBurnMachineDesign;

public class BeanFishBurnShop implements FishBurnMachineDesign {

    @Override
    public String taste() {
        return "팥빵";
    }

    @Override
    public int roastTime() {
        return 5; // 굽는 시간
    }

    @Override
    public int firePower() {
        return 8; // 1부터 10까지라면
    }

    @Override
    public int electricityConsumption() {
        return 40; // 5분동안 불의 강도 8로 붕어빵 굽는 기준
    }

    @Override
    public String signatureBurn() {
        return "시그니처 붕어빵";
    }

    @Override
    public String shopName(String name) {
        if (name != null && name.trim().length() != 0) {
            return "30년 전통 " + name + " 붕어빵 가게";
        } else {
            return "신규 붕어빵 가게";
        }
    }
}
