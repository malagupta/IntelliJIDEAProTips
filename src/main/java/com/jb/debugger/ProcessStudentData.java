package com.jb.debugger;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class ProcessStudentData {
    static List<Student> students = new ArrayList<>();

    static void init() {
        Faker faker = new Faker();
        for (int i = 0; i < 20; ++i) {
            students.add(new Student("ID" + i, faker.name().fullName()));
            System.out.println(students.get(i));
        }
        students.add(new Student("ID705", "Java"));
    }

    boolean findStudent(String id, String n) {
        return students.contains(
                new Student(id,n.toUpperCase()));
    }

    public static void main(String[] args) {
        System.out.println("Populate student list");
        init();
        System.out.println("Find a student in the list");
        boolean found = students.contains(new Student("ID105", "Java"));
    }
}
