package com.jb.code_analysis.inspections;

import java.util.Objects;

final class Person2 {
    private final String name;
    private final int age;

    Person2(String name, int age) {
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
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person[" + "name=" + name + ", " + "age=" + age + ']';
    }
}

