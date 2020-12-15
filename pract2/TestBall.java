package pract2;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball(10, 10);
        Ball b2 = new Ball();

        System.out.println(b1.getX());
        b1.setXY(20, 20);
        System.out.println(b1.getX() + " " + b1.getY());
        b2.setXY(555, 777);
        System.out.println(b2.getX() + " " + b2.getY());

        b1.move(100, 100);
        System.out.println(b1.getX() + " " + b1.getY());

    }
}
