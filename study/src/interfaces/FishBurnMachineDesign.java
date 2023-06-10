package interfaces;

public interface FishBurnMachineDesign extends SignatureMachineDesign {

    int ROAST_TIME_SET = 3;

    // static final 생략 가능
    static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



    String taste();     // 맛
    int roastTime();    // 굽기 시간 조절

    // abstract 생략 가능
    abstract int firePower();    // 불의 강도
    abstract int electricityConsumption(); // 전기 소모량

    // 가게 간판 만들기
    default String shopName(String name) {
        String firstName = shopFirstName();
        if (name != null && name.trim().length() != 0) {
            return firstName + name + " 붕어빵 가게";
        } else {
            return firstName + "신규 붕어빵 가게";
        }
    }

    static String headOfficeName() {
        String firstName = headOfficeFirstName();
        return firstName + "붕어빵 본사";
    }

    private String shopFirstName() {
        return "옛 추억 ";
    }

    private static String headOfficeFirstName() {
        return "옛 추억 ";
    }
}
