package lab5;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(args[0]);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
