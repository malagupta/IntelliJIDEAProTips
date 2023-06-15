package com.jb.code_analysis.inspections.magic_numbers;

public class MagicNumbers {
    void checkFileSize(long bytes) {
        if (bytes > 1_048_576) {
            throw new IllegalArgumentException("too big");
        } else if (bytes != -1 && bytes > 981_987_09) {
            throw new IllegalArgumentException("Hello!");
        }
    }
}
