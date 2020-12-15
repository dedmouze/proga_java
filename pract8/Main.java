package pract8;

public class Main {
    public static void main(String[] args) {

        IWaitList<Integer> test1 = new WaitList<>();
        test1.add(10);
        test1.add(20);
        test1.add(30);
        System.out.println(test1);
        test1.remove();
        System.out.println(test1);
        System.out.println("WaitList content contains 30? Answer: " + test1.contains(30) + "\n");

        IWaitList<Integer> test2 = new BoundedWaitList<>(10);
        for (int i = 0; i < 11; i++)
        {
            test2.add(i);
        }
        System.out.println(test2 + "\n");

        UnfairWaitList<String> test3 = new UnfairWaitList<>();
        test3.add("A");
        test3.add("B");
        test3.add("C");
        System.out.println(test3);
        test3.moveToBack();
        System.out.println(test3);
    }

}
