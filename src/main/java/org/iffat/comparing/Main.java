package org.iffat.comparing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruits = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruits) {
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Arrays.sort(fruits);
        System.out.println(Arrays.deepToString(fruits));

        System.out.println("A:" + (int) 'A' + " " + "a:" + (int) 'a');
        System.out.println("B:" + (int) 'B' + " " + "b:" + (int) 'b');
        System.out.println("P:" + (int) 'P' + " " + "p:" + (int) 'p');

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Ann")};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return name.compareTo(other.name);
    }
}
