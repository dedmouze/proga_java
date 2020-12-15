package Lab_16;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MFrame extends JFrame {

    enum Palette{
        UNDER_WHITE(209, 204, 196),
        UNDER_GRAY(225, 213, 165),
        UNDER_GRAY_2(237, 224, 173),
        UNDER_BROWN(160, 121, 69),
        BROWN(124, 74, 36),
        UNDER_BLACK(49, 19, 14);


        private Color color;
        Palette(int r, int g, int b){
            this.color = new Color(r, g, b);
        }

        public Color getColor() {
            return color;
        }
    }

    public void update(int t_num, int i_num){
        orderInformation.setText(tom.to_String(t_num));
        tableOrders.setSelectedIndex(t_num);
        internet_nums=iom.getNames();
        internetOrders.setListData(internet_nums);
        if (internet_nums.length>0){
            internet_orderInformation.setText(iom.to_String(i_num));
            internetOrders.setSelectedIndex(i_num);
        }
        else{
            internet_orderInformation.setText("There is no internet orders");
        }


    }



    String[] table_nums = {"First table", "Second table", "Third table", "Fourth table", "Fifth table", "Sixth table", "Seventh table", "VIP table"};
    String[] internet_nums;

    JTextArea orderInformation;
    JTextArea internet_orderInformation;
    JList tableOrders;
    JList internetOrders;
    TableOrdersManager tom;
    InternetOrdersManager iom;
    MFrame(TableOrdersManager tom, InternetOrdersManager iom){
        super("Restaurant Service");
        this.tom = tom;
        this.iom = iom;
        this.setSize(600,800);
        this.setLayout(new BorderLayout());

        JPanel labels = new JPanel(new GridLayout(0, 2));
        labels.setBackground(Palette.UNDER_WHITE.getColor());
        labels.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel label_tableOrders = new JLabel("Table orders");
        label_tableOrders.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 17));
        label_tableOrders.setHorizontalAlignment(0);
        JLabel label_internetOrders = new JLabel("Internet orders");
        label_internetOrders.setHorizontalAlignment(0);
        label_internetOrders.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 17));
        JPanel panelOrders = new JPanel(new GridLayout(0, 2));

        JPanel panelBottom = new JPanel(new BorderLayout());

        JPanel panelButtons = new JPanel(new GridLayout(3, 2));

        orderInformation = new JTextArea(10, 10);
        orderInformation.setLineWrap(true);
        orderInformation.setWrapStyleWord(true);
        orderInformation.setText("Select order");
        orderInformation.setBackground(new Color(255, 250, 230));
        orderInformation.setEditable(false);
        orderInformation.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));

        JScrollPane Tscroll = new JScrollPane(orderInformation,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Tscroll.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        internet_orderInformation = new JTextArea();
        internet_orderInformation.setText("Select order");
        internet_orderInformation.setBackground(new Color(255, 250, 230));
        internet_orderInformation.setEditable(false);
        internet_orderInformation.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));

        JScrollPane Iscroll = new JScrollPane(internet_orderInformation,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Iscroll.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPanel oInfo = new JPanel(new GridLayout(0, 2));
        oInfo.setPreferredSize(new Dimension(600, 300));
        Tscroll.setBackground(new Color(255, 250, 230));
        Iscroll.setBackground(new Color(255, 250, 230));



        this.tableOrders = new JList();
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)tableOrders.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        tableOrders.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selected = ((JList<?>)e.getSource()).getSelectedIndex();
                orderInformation.setText(tom.to_String(selected));
                System.out.println(selected);
            }
        });
        tableOrders.setLayoutOrientation(JList.VERTICAL);
        tableOrders.setListData(table_nums);
        tableOrders.setBackground(Palette.UNDER_GRAY.getColor());

        this.internetOrders = new JList();
        DefaultListCellRenderer rendererI =  (DefaultListCellRenderer)internetOrders.getCellRenderer();
        rendererI.setHorizontalAlignment(JLabel.CENTER);
        internetOrders.setLayoutOrientation(JList.VERTICAL);
        internetOrders.setBackground(Palette.UNDER_GRAY_2.getColor());
        internetOrders.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selected = ((JList<?>)e.getSource()).getSelectedIndex();
                if (selected!=-1){
                    internet_orderInformation.setText(iom.to_String(selected));
                }
                else {
                    internet_orderInformation.setText("There is no internet orders");
                }
            }
        });

        update(0, 0);




        add(labels, BorderLayout.PAGE_START);
        labels.add(label_tableOrders);
        labels.add(label_internetOrders);

        add(panelOrders, BorderLayout.CENTER);
        panelOrders.add(tableOrders);
        panelOrders.add(internetOrders);

        add(panelBottom, BorderLayout.PAGE_END);
        panelBottom.add(oInfo, BorderLayout.CENTER);
        oInfo.add(Tscroll);
        oInfo.add(Iscroll);

        panelBottom.add(panelButtons, BorderLayout.PAGE_END);


        JButton addIO = new JButton("Add Internet Order");
        addIO.setBackground(new Color(231, 197, 136));
        addIO.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                AddInternetOrder(iom);
            }
        });
        JButton addTO = new JButton("Add Table Order");
        addTO.setBackground(new Color(236, 203, 167));
        addTO.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                AddOrder(tom, tableOrders);
            }
        });
        JButton addTOI = new JButton("Add Item to Table Order");
        addTOI.setBackground(new Color(245, 217, 161));
        addTOI.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                TAddItem(tom, tableOrders);
            }
        });
        JButton removeTO = new JButton("Remove Table Order");
        removeTO.setBackground(new Color(236, 206, 164));
        removeTO.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int selected = tableOrders.getSelectedIndex();
                tom.remove(selected);
                orderInformation.setText("DELETED");
            }
        });
        JButton removeIO = new JButton("Remove Internet Order");
        removeIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                iom.remove();
                update(tableOrders.getSelectedIndex(), 0);
            }
        });
        removeIO.setBackground(new Color(243, 212, 173));
        JButton addIOI = new JButton("Add Item to Internet Order");
        addIOI.setBackground(new Color(231, 198, 158));
        addIOI.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int select = internetOrders.getSelectedIndex();
                if (select !=-1){
                    IAddItem(select, iom);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Choose correct internet order");
                }
            }
        });
        addTO.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addIO.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addTOI.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addIOI.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        removeTO.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        removeIO.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelButtons.add(addTO);
        panelButtons.add(addIO);
        panelButtons.add(addTOI);
        panelButtons.add(addIOI);
        panelButtons.add(removeTO);
        panelButtons.add(removeIO);

        this.setResizable(false);
        this.setVisible(true);
    }

    public void IAddItem(int select, InternetOrdersManager iom) {
        AddItemForm aif = new AddItemForm(iom.getOrders()[select], tableOrders.getSelectedIndex(), select, this);
    }

    public void AddInternetOrder(InternetOrdersManager iom) {
        AddInternetOrderForm aiof = new AddInternetOrderForm(iom, tableOrders.getSelectedIndex(), this);
    }

    public void TAddItem(TableOrdersManager tom, JList tableOrders) {
        if (tom.getOrder(tableOrders.getSelectedIndex())==null){
            JOptionPane.showMessageDialog(null, "This order is not exists");
        }
        else {
            AddItemForm adf = new AddItemForm(tom.getOrder(tableOrders.getSelectedIndex()), tableOrders.getSelectedIndex(), internetOrders.getSelectedIndex(), this);
        }
    }

    public void AddOrder(TableOrdersManager tom, JList tableOrders) {
        AddOrderForm adf = new AddOrderForm(tom, tableOrders.getSelectedIndex(), internetOrders.getSelectedIndex(),  this);
    }
}
