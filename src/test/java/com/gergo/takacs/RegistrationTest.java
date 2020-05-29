package com.gergo.takacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest {
    @BeforeEach
    public void setup() {
        TestRegistry.testCases.clear();
    }

    @Test
    public void testItRegistrationName() {
        TestExecution testExecution = () -> {
            assertTrue(false);
        };
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void test() {
                it("should do something", testExecution);
            }
        };
        abstractTest.test();
        assertEquals(new TestCase("should do something", testExecution), TestRegistry.testCases.get(0));
    }

    @Test
    public void testDescribeItRegistrationName() {
        TestExecution testExecution = () -> {
            assertTrue(false);
        };
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void test() {
                describe("my First test", () -> {
                    it("should do something", testExecution);
                });
            }
        };
        abstractTest.test();
        assertEquals(new TestCase("my First test - should do something", testExecution), TestRegistry.testCases.get(0));
    }

    @Test
    public void test2ItInDescribeRegistrationName() {
        TestExecution testExecution = () -> {
            assertTrue(false);
        };
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void test() {
                describe("my First test", () -> {
                    it("should do something", testExecution);
                    it("should do something2", testExecution);
                });
            }
        };
        abstractTest.test();
        assertEquals(new TestCase("my First test - should do something", testExecution), TestRegistry.testCases.get(0));
        assertEquals(new TestCase("my First test - should do something2", testExecution), TestRegistry.testCases.get(1));
    }

    @Test
    public void testItaOutsideAndInDescribeRegistrationName() {
        TestExecution testExecution = () -> {
            assertTrue(false);
        };
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void test() {
                it("should do something", testExecution);
                describe("my First test", () -> {
                    it("should do something2", testExecution);
                });
            }
        };
        abstractTest.test();
        assertEquals(new TestCase("should do something", testExecution), TestRegistry.testCases.get(0));
        assertEquals(new TestCase("my First test - should do something2", testExecution), TestRegistry.testCases.get(1));
    }

    @Test
    public void testItInDescribeAndOutsideRegistrationName() {
        TestExecution testExecution = () -> {
            assertTrue(false);
        };
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void test() {
                describe("my First test", () -> {
                    it("should do something", testExecution);
                });
                it("should do something2", testExecution);
            }
        };
        abstractTest.test();
        assertEquals(new TestCase("my First test - should do something", testExecution), TestRegistry.testCases.get(0));
        assertEquals(new TestCase("should do something2", testExecution), TestRegistry.testCases.get(1));
    }

    @Test
    public void testItInDescribeInsideDescribeRegistrationName() {
        TestExecution testExecution = () -> {
            assertTrue(false);
        };
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void test() {
                describe("my First test", () -> {
                    describe("an other group", () -> {
                        it("should do something", testExecution);
                    });
                });
            }
        };
        abstractTest.test();
        assertEquals(new TestCase("my First test - an other group - should do something", testExecution), TestRegistry.testCases.get(0));
    }
}
