package com.jb.code_analysis.inspections.verbose_redundant_code;

import java.util.List;

record Label(String name) {}

public class ProcessUtil {

    boolean checkRange(int num) {
        return (num == 3);
    }

    static void sort(List<Label> personList) {
        personList.sort((o1, o2) -> o1.name()
                              .compareToIgnoreCase(o2.name()));
    }

    int getAmount(String code) {
        final int amt;
        if (code.equals("I")) {
            amt = 10;
        } else if (code.equals("II")) {
            amt = 30;
        } else {
            amt = 40;
        }
        return amt;
    }
}
