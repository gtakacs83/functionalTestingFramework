package com.gergo.takacs;

import java.util.List;
import java.util.stream.Stream;

public class TestRunner {
    public Stream<TestResult> run(List<TestCase> testCases) {
        return testCases.parallelStream().map(testCase -> {
            try {
                testCase.getTestExecution().execute();
                return TestResult.success(testCase);
            } catch (Throwable t) {
                return TestResult.fail(testCase, t);
            }
        });
    }
}
