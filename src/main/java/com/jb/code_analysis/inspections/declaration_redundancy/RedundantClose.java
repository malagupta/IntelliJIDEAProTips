package com.jb.code_analysis.inspections.declaration_redundancy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RedundantClose {
    void aMethod() {
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
