package pract9;

import pract9.exception.StudentNameException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws StudentNameException {
        ArrayList<Student> arrayList = new ArrayList<>(20);

        /*
        * Есть массив студентов, нужно иметь возможность его отсортировать (реализована быстрая сортировка)
        * и найти балл по ФИО студента, если ФИО не найдено, выдавать исключение.
        * */


        for (int i = 0; i < 5; i++){
            arrayList.add(new Student("Test " + i, (int)(Math.random() * 10 + 20)));
        }
        System.out.println("Неотсортированный список студентов: ");
        for (int i = 0; i < 5; i++){
            System.out.println(arrayList.get(i).getName() + " " + arrayList.get(i).getSumOrder());
        }

        Student.sort_students(arrayList);

        System.out.println("Отсортированный список студентов: ");
        for (int i = 0; i < 5; i++){
            System.out.println(arrayList.get(i).getName() + " " + arrayList.get(i).getSumOrder());
        }

        System.out.println("\nПолучение баллов студента Test 3: ");
        Student.find_student(arrayList, "Test 3");
        Student.find_student(arrayList, "Test 223");
    }
}
