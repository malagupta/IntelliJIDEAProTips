package com.jb.code_analysis.inspections.thread_issues;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafetyDemo {
    private final List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int getSum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
