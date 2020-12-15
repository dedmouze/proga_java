package ru.chalovai.PR10;

public class MagicChair  implements Chair{
    public void doMagic(){
        System.out.println("Magic!");
    }

    public MagicChair(){
        doMagic();
    }

    @Override
    public String toString() {
        return "Magic Chair";
    }
}
