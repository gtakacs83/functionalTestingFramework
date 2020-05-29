package com.gergo.takacs;

import lombok.Value;

@Value
public class TestResult {

    private final String name;
    private final Throwable throwable;

    public TestResult(String name) {
        this(name, null);
    }

    public TestResult(String name, Throwable throwable) {
        this.name = name;
        this.throwable = throwable;
    }

    public static TestResult success(TestCase testCase) {
        return new TestResult(testCase.getName());
    }
    public static TestResult fail(TestCase testCase, Throwable throwable) {
        return new TestResult(testCase.getName(), throwable);
    }
}
