package com.gergo.takacs;

import java.util.ArrayList;
import java.util.Stack;

public abstract class AbstractTest {
    private final Stack<String> groupName = new Stack<>();

    public void describe(String groupName, TestRegistration registration) {
        this.groupName.push(groupName);
        registration.register();
        this.groupName.pop();
    }

    public void it(String testName, TestExecution testExecution) {
        String name = calculateName(testName);
        TestCase testCase = new TestCase(name, testExecution);
        TestRegistry.testCases.add(testCase);
    }

    private String calculateName(String testName) {
        ArrayList<String> names = new ArrayList<>(this.groupName);
        names.add(testName);
        return String.join(" - ", names);
    }

    public abstract void test();
}
