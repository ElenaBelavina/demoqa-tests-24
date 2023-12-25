package guru.qa;

import org.junit.jupiter.api.*;

public class SimpleJunitTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("\n\n### @BeforeAll\n");
    }
    @AfterAll
    static void agterAll(){
        System.out.println("### @AfterAll\n\n");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("###     @BeforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("###@    AfterEach");
        System.out.println();
    }
    @Test
    void firstTest(){
        System.out.println("###         @Test firstTest");
        Assertions.assertTrue(2*2==4);

    }
    @Test
    void secondTest(){
        System.out.println("###        @Test secondTest");
        Assertions.assertTrue(2+2==4);

    }

}
