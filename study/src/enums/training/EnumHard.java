package enums.training;

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

public class EnumHard {

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
    }
}
