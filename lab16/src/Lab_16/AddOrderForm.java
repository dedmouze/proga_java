package Lab_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddOrderForm extends JFrame {


    private void nextStep(Order o){
        AddItemForm aif = new AddItemForm(tableOrder, t_num, i_num, mFrame);
        mFrame.update(t_num, i_num);
    }

    private boolean set_order(int t_table_num){
        try {
            tom.add(tableOrder, t_table_num);
            return true;
        } catch (TableOrdersManager.OrderAlreadyAddedException orderAlreadyAddedException) {
            if(tom.freeTableNumbers().length>0){
                t_num=tom.freeTableNumbers()[0];
                return set_order(tom.freeTableNumbers()[0]);
            }
        } catch (TableOrdersManager.IllegalTableNumber illegalTableNumber){
            if(tom.freeTableNumbers().length>0){
                t_num=tom.freeTableNumbers()[0];
                return set_order(tom.freeTableNumbers()[0]);
            }
        }
        JOptionPane.showMessageDialog(null, "Restaurant is full");
        return false;
    }


    TableOrder tableOrder = new TableOrder();;
    TableOrdersManager tom;
    JTextArea order_info;
    int t_num;
    int i_num;
    MFrame mFrame;
    AddOrderForm(TableOrdersManager tom, int t_num, int i_num,  MFrame mFrame){
        super("Order maker");
        this.tom = tom;
        this.order_info=order_info;
        this.t_num=t_num;
        this.i_num=i_num;
        this.mFrame=mFrame;


        setResizable(false);
        setSize(400, 200);
        setBackground(new Color(255, 218, 190));

        JPanel MPanel = new JPanel(new GridLayout(5, 2));
        MPanel.setBackground(new Color(255, 218, 190));
        MPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 2, 5));

        JLabel fname = new JLabel("First name: ");
        fname.setHorizontalAlignment(JLabel.CENTER);
        JLabel sname = new JLabel("Second name: ");
        sname.setHorizontalAlignment(JLabel.CENTER);
        JLabel age = new JLabel("Age name: ");
        age.setHorizontalAlignment(JLabel.CENTER);
        JLabel table_num = new JLabel("Table num [0-7]: ");
        table_num.setHorizontalAlignment(JLabel.CENTER);

        JTextField t_fname = new JTextField();
        t_fname.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_sname = new JTextField();
        t_sname.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_age = new JTextField();
        t_age.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_table_num = new JTextField();
        t_table_num.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        t_table_num.setHorizontalAlignment(JTextField.CENTER);
        t_table_num.setText(Integer.toString(t_num));
        t_table_num.setEditable(false);

        JButton IDN = new JButton("I don't know");
        IDN.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        IDN.setBackground(new Color(255, 234, 211));
        JButton b_nextStep = new JButton("Next step");
        b_nextStep.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        b_nextStep.setBackground(new Color(255, 234, 211));

        add(MPanel);
        MPanel.add(fname);
        MPanel.add(t_fname);
        MPanel.add(sname);
        MPanel.add(t_sname);
        MPanel.add(age);
        MPanel.add(t_age);
        MPanel.add(table_num);
        MPanel.add(t_table_num);
        MPanel.add(IDN);
        MPanel.add(b_nextStep);
        setVisible(true);

        b_nextStep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Customer customer = new Customer(t_fname.getText(), t_sname.getText(), Integer.parseInt(t_age.getText()), Address.EMPTY_ADDRESS);
                tableOrder.setCustomer(customer);
                boolean check = set_order(Integer.parseInt(t_table_num.getText()));
                mFrame.update(t_num, i_num);
                if(check){nextStep(tableOrder);}
                dispose();
            }
        });

        IDN.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean check = set_order(Integer.parseInt(t_table_num.getText()));
                System.out.println(check);
                mFrame.update(t_num, i_num);
                if(check){nextStep(tableOrder);}
                dispose();
            }
        });
    }
}
