package junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class JunitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println(" @BeforeAll : 전체 테스트에서 처음 한번만 실행 된다.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("  @AfterAll : 전체 테스트에서 마지막 한번만 실행 된다.");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach : 테스트에서 각 테스트가 진행될 때  실행 된다.");
    }

    @AfterEach
    void afterEach() {
        System.out.println(" @AfterEach : 테스트에서 각 테스트가 종료될 때  실행 된다.");
    }

    @Test
    void test() {
        System.out.println("      @Test : 테스트 케이스");
    }

    @Test
    @Disabled
    void test2() {
        System.out.println("@Disabled : 테스트에서 제외 시킨다.");
    }
}
