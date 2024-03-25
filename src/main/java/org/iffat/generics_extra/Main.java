package org.iffat.generics_extra;

import org.iffat.generics_extra.model.LPAStudent;
import org.iffat.generics_extra.model.LPAStudentComparator;
import org.iffat.generics_extra.model.Student;
import org.iffat.generics_extra.util.QueryItem;
import org.iffat.generics_extra.util.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        // printList(students);
        printMoreList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        // printList(lpaStudents);
        printMoreList(lpaStudents);

        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("course", "Python");
        printMoreList(matches);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreList(students2021);

        // QueryList<Employee> employeeQueryList = new QueryList<>();

        QueryList<LPAStudent> queryLists = new QueryList<>();
        for (int i = 0; i<25; i++) {
            queryLists.add(new LPAStudent());
        }
        System.out.println("Ordered");
        queryLists.sort(Comparator.naturalOrder());
        printList(queryLists);

        System.out.println("Matches");
        var matches2 = queryList
                .getMatches("PercentComplete", "50")
                .getMatches("course","Python");
        matches2.sort(new LPAStudentComparator());
        printList(matches2);

        System.out.println("Ordered");
        matches2.sort(null);
        printList(matches2);
    }

    public static void printMoreList(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void printList(List<?> students) {

        for (var student: students) {
            System.out.println(student);
        }
    }

    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

//    public static void testList(List<String> list) {
//
//        for (var element: list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//
//        for (var element: list) {
//            System.out.println("String: " + element.intValue());
//        }
//    }

//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }
}
