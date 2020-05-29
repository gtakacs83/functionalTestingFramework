package com.gergo.takacs;

import lombok.Value;

@Value
public class TestCase {
    private final String name;
    private final TestExecution testExecution;

    public TestCase(String name, TestExecution testExecution) {
        this.name = name;
        this.testExecution = testExecution;
    }
}
