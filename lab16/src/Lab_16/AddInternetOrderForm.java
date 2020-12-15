package Lab_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddInternetOrderForm extends JFrame {

    InternetOrdersManager iom;
    int i_num;
    int t_num;
    AddInternetOrderForm(InternetOrdersManager iom, int t_num, MFrame mframe){
        super("Internet Order Form");
        this.iom=iom;
        this.t_num=t_num;
        this.i_num=i_num;
        setSize(300, 270);
        setLayout(new BorderLayout());
        setResizable(false);

        JLabel hedln = new JLabel("New customer form. You must fill all fields");
        JPanel p_hedln = new JPanel();
        p_hedln.setBackground(new Color(255, 244, 207));
        hedln.setHorizontalAlignment(0);
        hedln.setBorder(BorderFactory.createEmptyBorder(14, 5, 14, 5));

        JPanel form = new JPanel(new GridLayout(7, 2));
        form.setBackground(new Color(236, 221, 205));
        form.setBorder(BorderFactory.createEmptyBorder(5, 5,5, 5));
        JLabel l_fname = new JLabel("First name: ");
        JLabel l_sname = new JLabel("Second name: ");
        JLabel l_age = new JLabel("Age: ");
        JLabel l_city = new JLabel("City: ");
        JLabel l_street = new JLabel("Street: ");
        JLabel l_building_num = new JLabel("Building Number: ");
        JLabel l_apart = new JLabel("Apartment: ");

        l_fname.setHorizontalAlignment(0);
        l_sname.setHorizontalAlignment(0);
        l_age.setHorizontalAlignment(0);
        l_city.setHorizontalAlignment(0);
        l_street.setHorizontalAlignment(0);
        l_building_num.setHorizontalAlignment(0);
        l_apart.setHorizontalAlignment(0);

        JTextField t_fname = new JTextField();
        t_fname.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_sname = new JTextField();
        t_sname.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_age = new JTextField();
        t_age.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_city = new JTextField();
        t_city.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_street = new JTextField();
        t_street.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_building_num = new JTextField();
        t_building_num.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JTextField t_apart = new JTextField();
        t_apart.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        JButton b_confirm = new JButton("Confirm");
        b_confirm.setBackground(new Color(255, 207, 158));
        b_confirm.setMargin(new Insets(5, 5, 5, 5));
        b_confirm.setBorder(BorderFactory.createEmptyBorder(8, 5,8 ,5 ));
        b_confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String fname = t_fname.getText().trim();
                System.out.println("*"+fname);
                String sname = t_sname.getText().trim();
                System.out.println("*"+sname);
                String s_age = t_age.getText().trim();
                int age = 18;
                try{
                    age= Integer.parseInt(s_age);
                } catch (Exception t){
                    System.out.println(t.getMessage());
                }
                String city = t_city.getText().trim();
                String street = t_street.getText().trim();
                String s_building_num=t_building_num.getText().trim();
                int building_num = 0;
                try{
                    building_num= Integer.parseInt(s_building_num);
                } catch (Exception t){
                    System.out.println(t.getMessage());
                }

                String s_apart=t_apart.getText().trim();
                int apart = 0;
                try{
                    apart= Integer.parseInt(s_apart);
                } catch (Exception t){
                    System.out.println(t.getMessage());
                }

                if (fname.length()==0 || sname.length()==0 || s_age.length()==0 || city.length()==0 || street.length()==0 || s_building_num.length()==0 || s_apart.length()==0){
                    JOptionPane.showMessageDialog(null, "YOU MUST FILL ALL FIELDS!");
                    return;
                }
                InternetOrder io = new InternetOrder();
                io.setCustomer(new Customer(fname, sname, age, new Address(city, street, 0, building_num, 'a', apart)));
                iom.add(io);
                mframe.update(t_num, 0);
                AddItemForm aif = new AddItemForm(io, t_num, 0, mframe);
                dispose();

            }
        });

        add(p_hedln, BorderLayout.PAGE_START);
        p_hedln.add(hedln);
        add(form, BorderLayout.CENTER);
        form.add(l_fname);
        form.add(t_fname);
        form.add(l_sname);
        form.add(t_sname);
        form.add(l_age);
        form.add(t_age);
        form.add(l_city);
        form.add(t_city);
        form.add(l_street);
        form.add(t_street);
        form.add(l_building_num);
        form.add(t_building_num);
        form.add(l_apart);
        form.add(t_apart);
        add(b_confirm, BorderLayout.PAGE_END);

        setVisible(true);
    }
}
