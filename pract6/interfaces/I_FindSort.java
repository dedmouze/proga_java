package pract9.interfaces;

import pract9.Student;
import pract9.exception.StudentNameException;

import java.util.ArrayList;

public interface I_FindSort {
    static void find_student(ArrayList<Student> listStudents, String student_name) throws StudentNameException { }
    static void sort_students(ArrayList<Student> listStudents) { }
}
