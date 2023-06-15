package com.jb.code_analysis.inspections.version_upgrade;
import com.github.javafaker.Faker;
import com.jb.debugger.Student;

import java.util.ArrayList;
import java.util.List;

public class DataProcessing {
    static List<Student> students = new ArrayList<>();

    static void init() {
        Faker faker = new Faker();
        for (int i = 0; i < 20; ++i) {
            students.add(new Student("ID" + i, faker.name().fullName()));
            System.out.println(students.get(i));
        }
        students.add(new Student("ID105", "Java"));
    }

    boolean findStudent(String id, String name) {
        return students.contains(
                new Student(id, name));
    }

    public static void main(String[] args) {
        System.out.println("Populate student list");
        init();
        System.out.println("Find a student in the list");
        boolean found = students.contains(new Student("ID105", "Java"));
    }
}
