package com.jb.code_analysis.inspections.verbose_redundant_code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExcessiveRangeCheckTest {
    @Test
    @DisplayName("Test name")
    void testName() {
        ProcessUtil check = new ProcessUtil();
        System.out.println(check.checkRange(10));
        System.out.println(check.checkRange(8765));
        System.out.println(check.getAmount("H"));
        System.out.println(check.getAmount("JHG"));
        ProcessUtil.sort(null);
        List<Label> list = new ArrayList<>();
        list.add(new Label("hjh"));
        ProcessUtil.sort(new ArrayList<>(list));


    }
}