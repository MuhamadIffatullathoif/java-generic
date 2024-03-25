package org.iffat.generics_extra;

import org.iffat.generics_extra.model.LPAStudent;
import org.iffat.generics_extra.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);
    }

    public static void printList(List students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
