package com.jb.debugger.stepping;
import java.util.ArrayList;
import java.util.List;

public class ProcessStudentData {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student(1, "Haryyn");
        Student student2 = new Student(2, "Shreya");

        students.add(student1);
        students.add(student2);

        fixSpellingErrorInStudentList(students, 1, "Haryyn", "Harry");
        System.out.println(students);
    }

    public static void fixSpellingErrorInStudentList(List<Student> studentList,
                                                     int studentID,
                                                     String oldName,
                                                     String correctName) {

        int index = studentList.indexOf(new Student(studentID, oldName));

        if (index != -1) {
            studentList.set(index, new Student(studentID, correctName));
        }
    }
}