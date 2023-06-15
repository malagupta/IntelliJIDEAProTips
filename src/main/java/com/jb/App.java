package com.jb;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    boolean CheckAge(Person person, int age) {
        return (person != null && person.age() == age);
    }

    List<Person> filterAgeGreaterThan(List<Person> people, int age) {
        return people.stream()
                     .filter(e -> e.age() > age)
                     .toList();
    }


    List<Person> filterRange(List<Person> people, int low, int high) {
        return people.stream()
                     .filter(e -> e.age() >= low && e.age() <= high)
                     .toList();

    }



    record Person(String name, int age) { }

}
