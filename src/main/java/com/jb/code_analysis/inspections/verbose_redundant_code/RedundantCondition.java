package com.jb.code_analysis.inspections.verbose_redundant_code;

public class RedundantCondition {
    void checkFileSize(long bytes) {
        if (bytes != -1 && bytes > 981_987_09) {
            throw new IllegalArgumentException("Illegal value");
        }
    }
}
