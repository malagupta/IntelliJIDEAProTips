package com.jb.code_analysis.inspections.version_upgrade;

public record Pencil(String type, int length) {
    public Pencil(String type, int length) {
        this.type = type;
        this.length = length;
    }
}
