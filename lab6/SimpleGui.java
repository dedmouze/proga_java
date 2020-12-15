package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui extends JFrame {
    private JButton b_center = new JButton("CENTER");
    private JButton b_west = new JButton("WEST");
    private JButton b_east = new JButton("EAST");
    private JButton b_north = new JButton("NORTH");
    private JButton b_south = new JButton("SOUTH");

    private String[] s = {"Эр-Рияд", "Джидду", "Абха", "Медину", "Дахране"};
    private MyDialog[] dialogs = new MyDialog[5];

    public SimpleGui()
    {
        setTitle("Test");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        /* Создание диалоговых окон */
        int i = 0;
        for (String city : s)
        {
            dialogs[i] = new MyDialog(SimpleGui.this, city);
            //dialogs[i].setSize(200, 90);
            i++;
        }

        /* Слушатели, реагируещие при наведении */
        b_center.addMouseListener(new ButtonEventListener());
        b_east.addMouseListener(new ButtonEventListener());
        b_west.addMouseListener(new ButtonEventListener());
        b_north.addMouseListener(new ButtonEventListener());
        b_south.addMouseListener(new ButtonEventListener());

        /* Позиционирование кнопок */
        add(b_center, BorderLayout.CENTER);
        add(b_east, BorderLayout.EAST);
        add(b_west, BorderLayout.WEST);
        add(b_north, BorderLayout.NORTH);
        add(b_south, BorderLayout.SOUTH);
    }

    class ButtonEventListener implements MouseListener {


        public void mouseClicked(MouseEvent e) { }
        public void mousePressed(MouseEvent e) { }
        public void mouseReleased(MouseEvent e) { }


        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton)e.getSource();
            String buttonText = "";

            if(b != null)
                buttonText = b.getText();

            switch (buttonText) {
                case "CENTER" -> dialogs[0].setVisible(true);
                case "WEST" -> dialogs[1].setVisible(true);
                case "SOUTH" -> dialogs[2].setVisible(true);
                case "NORTH" -> dialogs[3].setVisible(true);
                case "EAST" -> dialogs[4].setVisible(true);
            }
        }
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton)e.getSource();
            String buttonText = "";

            if(b != null)
                buttonText = b.getText();

            switch (buttonText) {
                case "CENTER" -> dialogs[0].setVisible(false);
                case "WEST" -> dialogs[1].setVisible(false);
                case "SOUTH" -> dialogs[2].setVisible(false);
                case "NORTH" -> dialogs[3].setVisible(false);
                case "EAST" -> dialogs[4].setVisible(false);
            }
        }
    }

    static class MyDialog extends JDialog
    {
        /*public void centreWindow(Window frame) {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
            super.setLocation(x, y);
        }*/

        public MyDialog(JFrame owner, String greeting)
        {
            super(owner, "MyDialog", false);
            super.setSize(200, 90);
            //centreWindow(this);
            super.setLocationRelativeTo(null);
            add(new JLabel("Добро пожаловать в " + greeting), BorderLayout.CENTER);
        }
    }

    public static void main(String[] args) {
        SimpleGui simpleGui = new SimpleGui();
        simpleGui.setVisible(true);
    }
}
