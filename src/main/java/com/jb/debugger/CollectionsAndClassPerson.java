package com.jb.debugger;

import java.util.ArrayList;
import java.util.List;

public class CollectionsAndClassPerson {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        final var javaPerson = new Person("Java");
        final var anotherJavaPerson = new Person("Java");

        people.add(javaPerson);
        System.out.println(people.contains(anotherJavaPerson));
    }
}
