package com.jb.code_analysis.inspections.verbose_redundant_code;

public class DuplicateSwitchBranch {
    void processData(int n) {
        switch (n) {
            case 1:
                System.out.println(n);
                break;
            case 2:
                System.out.println(n);
                break;
            default:
                System.out.println("default");
        }
    }
}
