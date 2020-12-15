package pract7;

public class Game {
    private SimpleQueue<Integer> q1 = new SimpleQueue<>();
    private SimpleQueue<Integer> q2 = new SimpleQueue<>();

    public Game(String[] s1, String[] s2) {
        for (int i = 0; i < s1.length; i++){
            q1.add(Integer.parseInt(s1[i]));
            q2.add(Integer.parseInt(s2[i]));
        }
    }

    public void startGame() {
        int cardFromFirst;
        int cardFromSecond;
        int amountTurn = 0;

        while (!q1.isEmpty() && !q2.isEmpty() && amountTurn < 106) {
            cardFromFirst = q1.remove();
            cardFromSecond = q2.remove();

            if (cardFromFirst > cardFromSecond) {
                q1.add(cardFromFirst);
                q1.add(cardFromSecond);
            }
            else {
                q2.add(cardFromSecond);
                q2.add(cardFromFirst);
            }
            amountTurn++;
        }
        if (q1.isEmpty())
            System.out.println("second " + amountTurn);
        else if (q2.isEmpty())
            System.out.println("first " + amountTurn);
        else
            System.out.println("botva");
    }
}
