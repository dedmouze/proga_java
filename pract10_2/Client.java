package ru.chalovai.PR10;

//Реализовать класс Абстрактная фабрика для различных типов стульев:
// Викторианский стул, Многофункциональный стул, Магический стул,
// а также интерфейс Стул, от которого наследуются все классы стульев,
// и класс Клиент, который использует интерфейс стул в своем методе Sit (Chair chair).

public class Client {
    private static Chair chair;

    public static void sit(){
        System.out.println("Sitting on " + chair);
    }

    public static void setChair(Chair chaiir){
        chair = chaiir;
    }

    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        String chair_type = "Magic";    // тип стула. Изменить для тестов на Functional или Victorian
        if(chair_type.equals("Magic"))
            setChair(factory.createMagicChair());
        else if(chair_type.equals("Functional"))
            setChair(factory.createFunctionalChair());
        else if(chair_type.equals("Victorian"))
            setChair(factory.createVictorianChair());

        sit();
    }
}
