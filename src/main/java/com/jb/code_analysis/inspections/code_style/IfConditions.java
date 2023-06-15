package com.jb.code_analysis.inspections.code_style;

import java.time.LocalTime;

public class IfConditions {
    boolean result(boolean foo) {
        boolean condition = LocalTime.now().getHour() > 10;

        if (condition) return true; else return foo;
    }
}
