package com.gergo.takacs;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRunnerTest {
    @Test
    public void testSuccess(){
        TestCase success = new TestCase("success", () -> {
            assertTrue(true);
        });
        List<TestResult> results = new TestRunner().run(Collections.singletonList(success)).collect(Collectors.toList());
        assertEquals(new TestResult("success"), results.get(0));
    }

    @Test
    public void testFail(){
        TestCase success = new TestCase("fail", () -> {
            assertTrue(false);
        });
        List<TestResult> results = new TestRunner().run(Collections.singletonList(success)).collect(Collectors.toList());
        TestResult testResult = results.get(0);
        assertEquals("fail", testResult.getName());
        assertThat(testResult.getThrowable(), instanceOf(AssertionError.class));
    }
}
