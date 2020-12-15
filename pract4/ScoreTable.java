package pract4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScoreTable extends JFrame {
    private JButton button1 = new JButton("AC Milan");
    private JButton button2 = new JButton("Real Madrid");

    private JLabel label1 = new JLabel("Result: 0 X 0");
    private JLabel label2 = new JLabel("Last Scorer: N/A");

    private Label winLabel = new Label("Winner: DRAW");

    private int firstCommandScore = 0;
    private int secondCommandScore = 0;


    public ScoreTable(){
        super("Score Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        button1.addActionListener(new ButtonEventListener());
        button2.addActionListener(new ButtonEventListener());


        add(button1, BorderLayout.WEST);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(3,1,2,2));
        container.add(label1);
        container.add(label2);
        container.add(winLabel);
        add(container, BorderLayout.CENTER);

        add(button2, BorderLayout.EAST);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "Result: ";
            String lastGoal = "Last Scorer: ";
            String winner = "Winner: ";

            if (e.getActionCommand().equals("AC Milan"))
                firstCommandScore++;
            else
                secondCommandScore++;
            message += firstCommandScore + " X " + secondCommandScore;
            label1.setText(message);

            lastGoal += e.getActionCommand();
            label2.setText(lastGoal);

            if (firstCommandScore > secondCommandScore)
                winner += "AC Milan";
            else
                winner += "Real Madrid";
            winLabel.setText(winner);
        }
    }

    public static void main(String[] args)
    {
        ScoreTable app = new ScoreTable();
        app.setVisible(true);
    }
}
