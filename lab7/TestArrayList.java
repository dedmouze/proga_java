package lab7;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Anna");
        students.add("Alex");
        students.add("Kate");

        System.out.println(students.get(2));
        System.out.println("Размер списка студентов: " + students.size());

        for(String student : students){
            System.out.println(student);
        }

        students.remove(0);
        students.remove(0);
        students.remove(0);
        System.out.println("Список студентов пуст? " + students.isEmpty());

        if(students.contains("Tom")){

            System.out.println("В списке есть Tom");
        }
        else{
            System.out.println("В списке нет Тома");
        }
    }
}
