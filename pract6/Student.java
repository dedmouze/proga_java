package pract9;

import pract9.exception.StudentNameException;
import pract9.interfaces.I_FindSort;

import java.util.ArrayList;

public class Student implements I_FindSort {
    private String name;
    private int sumOrder;

    public Student(String name, int sumOrder){
        this.name = name;
        this.sumOrder = sumOrder;
    }

    public int getSumOrder() { return sumOrder; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    public void setSumOrder(int sumOrder) { this.sumOrder = sumOrder; }

    static void find_student(ArrayList<Student> listStudents, String student_name) throws StudentNameException {
        for (Student student : listStudents) {
            if (student.getName().equals(student_name)) {
                System.out.println(student.getSumOrder());
                return;
            }
        }
        throw new StudentNameException();
    }

    static void sort_students(ArrayList<Student> listStudents)
    {
        QuickSort qs = new QuickSort();
        qs.quickSort(listStudents, 0, listStudents.size() - 1);
    }
}