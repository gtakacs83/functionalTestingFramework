package com.gergo.takacs;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HowATestWouldLook extends AbstractTest {
    @Override
    public void test() {
        describe("my First Tests", ()->{
            it("first test case", ()->{
                assertTrue(false);
            });
        });
    }
}
