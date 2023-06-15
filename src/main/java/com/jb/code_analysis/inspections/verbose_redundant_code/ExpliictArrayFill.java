package com.jb.code_analysis.inspections.verbose_redundant_code;

public class ExpliictArrayFill {
    void assignValuesToArray(int[] array, int[] calc) {
        for (int i=0; i<array.length; i++) {
            array[i] = calc[i];
        }
    }

    private int calc(int i) {
        return i * i;
    }
}
