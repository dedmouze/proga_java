package Prac_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonBase {
    HashMap<String, Integer> Base;
    String[] names = {
            "Artem",
            "Yaroslav",
            "Petr",
            "Ilya",
            "Anastasia",
            "Dmitriy",
            "Pavel",
            "Konstantin",
            "Grigoriy",
            "Maria",
            "Lize",
            "Katya",
            "Nadejda",
            "Michail"

    };

    public void check_ID(String name, int ID) throws NotCorrectIDEx, NotFoundEx{
        if (Base.containsKey(name)){
            if (Base.get(name)==ID){
                System.out.println("Checked");
            }
            else{
                throw new NotCorrectIDEx();
            }
        }
        else{
            throw new NotFoundEx();
        }
    }

    public PersonBase(){
        Base = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            Base.put(names[i], i);
        }
    }
}
