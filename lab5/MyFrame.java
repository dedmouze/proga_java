package lab5;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String path)
    {
        setTitle("MyFrame");
        setSize(600, 600);
        ImageComp imageComp = new ImageComp(path);
        add(imageComp);
    }
}
