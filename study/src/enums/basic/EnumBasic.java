package enums.basic;

enum Day {
    SUNDAY("일요일", true),
    MONDAY("월요일", false),
    TUESDAY("화요일", false),
    WEDNESDAY("수요일", false),
    THURSDAY("목요일", false),
    FRIDAY("금요일", false),
    SATURDAY("토요일", true);

    private String day;
    private boolean isWeekend;

    /**
     * Enum은 외부에서 생성 불가능 !
     */
    private Day(String day, boolean isWeekend) {
        this.day = day;
        this.isWeekend = isWeekend;
    }

    public String getKoreaDay() {
        return day;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}

enum Rgb {
    RED,
    GREEN,
    BLUE;
}

public class EnumBasic {

    public static void main(String[] args) {


        // 기본 호출
        System.out.println(Day.SUNDAY);
        System.out.println(Day.MONDAY);
        System.out.println(Day.TUESDAY);
        System.out.println(Day.WEDNESDAY);
        System.out.println(Day.THURSDAY);
        System.out.println(Day.FRIDAY);
        System.out.println(Day.SATURDAY);
        System.out.println();


        // 한국 요일
        System.out.println(Day.SUNDAY.getKoreaDay());
        System.out.println(Day.MONDAY.getKoreaDay());
        System.out.println(Day.TUESDAY.getKoreaDay());
        System.out.println(Day.WEDNESDAY.getKoreaDay());
        System.out.println(Day.THURSDAY.getKoreaDay());
        System.out.println(Day.FRIDAY.getKoreaDay());
        System.out.println(Day.SATURDAY.getKoreaDay());
        System.out.println();


        // 주말 확인
        System.out.println("   SUNDAY is weekend? : " + Day.SUNDAY.isWeekend());
        System.out.println("   MONDAY is weekend? : " + Day.MONDAY.isWeekend());
        System.out.println("  TUESDAY is weekend? : " + Day.TUESDAY.isWeekend());
        System.out.println("WEDNESDAY is weekend? : " + Day.WEDNESDAY.isWeekend());
        System.out.println(" THURSDAY is weekend? : " + Day.THURSDAY.isWeekend());
        System.out.println("   FRIDAY is weekend? : " + Day.FRIDAY.isWeekend());
        System.out.println(" SATURDAY is weekend? : " + Day.SATURDAY.isWeekend());
        System.out.println();


        // =====================================================================

        // 기본 호출 방식
        System.out.println(Rgb.RED);
        System.out.println(Rgb.GREEN);
        System.out.println(Rgb.BLUE);
        System.out.println();


        // 전체 호출 방식
        //  - values()
        Rgb[] rgbs = Rgb.values();
        for (int i = 0; i < rgbs.length; i++) {
            System.out.println("rgbs[" + i + "] : " + rgbs[i]);
        }
        System.out.println();


        // 문자열과 일치하는 열거체 상수 호출
        //  - valueOf(String string)
        Rgb red = Rgb.valueOf("RED");
        System.out.println("value = " + red);
        System.out.println();


        // 클래스와 문자열이 일치하는 열거체 상수 호출
        //  - valueOf(@NotNull Class<RGB>, @NotNull String string)
        Rgb blue = Rgb.valueOf(Rgb.class, "BLUE");
        System.out.println("value = " + blue);
        System.out.println();


        // 열거체가 정의된 순서를 반환
        // - ordinal()
        int ordinalRed   = Rgb.RED.ordinal();
        int ordinalGreen = Rgb.GREEN.ordinal();
        int ordinalBlue  = Rgb.BLUE.ordinal();
        System.out.println("ordinalRed   = " + ordinalRed);
        System.out.println("ordinalGreen = " + ordinalGreen);
        System.out.println("ordinalBlue  = " + ordinalBlue);
        System.out.println();


        // enum 비교
        // - equals(@Nullable Object other)
        boolean isEqual    = Rgb.RED.equals(Rgb.RED);
        boolean isNotEqual = Rgb.RED.equals(Rgb.BLUE);
        System.out.println("RGB.RED.equals(RGB.RED) result  = " + isEqual);
        System.out.println("RGB.RED.equals(RGB.BLUE) result = " + isNotEqual);
        System.out.println();


        // 해쉬코드 조회
        // - hashCode()
        int redHash   = Rgb.RED.hashCode();
        int greenHash = Rgb.GREEN.hashCode();
        int blueHash  = Rgb.BLUE.hashCode();
        System.out.println("redHash   = " + redHash);
        System.out.println("greenHash = " + greenHash);
        System.out.println("blueHash  = " + blueHash);
        System.out.println();


        // switch for syntax
        Rgb redSwitch   = Rgb.valueOf("RED");
        Rgb greenSwitch = Rgb.valueOf("GREEN");
        Rgb blueSwitch  = Rgb.valueOf("BLUE");
        enumSwitchSyntax(Rgb.valueOf("RED"));
        enumSwitchSyntax(Rgb.valueOf("GREEN"));
        enumSwitchSyntax(Rgb.valueOf("BLUE"));
    }

    public static void enumSwitchSyntax(Rgb rgb) {
        switch (rgb) {
            case RED:
                System.out.println("switch red");
                break;
            case GREEN:
                System.out.println("switch green");
                break;
            case BLUE:
                System.out.println("switch blue");
                break;
            default:
                System.out.println("default");
        }
    }
}
