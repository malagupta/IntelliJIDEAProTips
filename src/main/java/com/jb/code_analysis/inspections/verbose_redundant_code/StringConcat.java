package com.jb.code_analysis.inspections.verbose_redundant_code;

import org.jetbrains.annotations.NotNull;

public class StringConcat {
    void foo(int x, int y) {
        String s = "" + x + " ; " + y;
    }

    @NotNull
    private static String getEmptyString() {
        final String returnVal = "";
        return returnVal;
    }
}
