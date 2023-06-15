package com.jb.code_analysis.inspections;

import java.util.Objects;

final class Person3 {
    private final String name;
    private final int age;

    Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person3) obj;
        return Objects.equals(this.name, that.name) && this.age == that.age;
    }


}

