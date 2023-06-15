package com.jb.fun;
import com.jb.App;
import java.util.List;

record Person(String name, int age) { }

public class FontLigatures {

    boolean CheckAge(Person person, int age) {
        return (person != null && person.age() == age);
    }

    List<Person> filterRange(List<Person> people, int low, int high) {
        return people.stream()
                     .filter(e -> e.age() >= low && e.age() <= high)
                     .toList();

    }

}













