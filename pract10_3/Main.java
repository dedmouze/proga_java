package ru.chalovai.PR12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends JFrame {

    static JFrame f = new JFrame();
    static JTextArea area = new JTextArea();

    private static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void workWithTextFile(JFrame f, String path) throws IOException {
        f.add(area, BorderLayout.CENTER);
        String text = readFile(path);
        area.setText(text);
        if (text.isEmpty())
            area.setText("Text... ");
    }

    public static void main(String[] args) {

        AbstractFactory factory = new CreateTextDocument();
        String file_name = "New_file";

        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());

        JMenuBar bar = new JMenuBar();
        JMenu file_menu = new JMenu("File");
        JMenu window_menu = new JMenu("Window");
        bar.add(file_menu);
        bar.add(window_menu);

        // Создание файла
        JMenu new_menu = new JMenu("New");
        JMenuItem text_menu_item = new JMenuItem("Text");
        text_menu_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    factory.createDoc("text", "New_file");
                    workWithTextFile(f, System.getProperty("user.dir") + "\\" + file_name + ".txt");
                } catch (IOException ioException) {
                    // Возникает необрабатываемое исключение без блока try-catch
                    // Метод printStackTrace () класса Java.lang.Throwable, используемый для печати этого
                    // Throwable, наряду с другими деталями, такими как имя класса и номер строки, где
                    // произошло исключение, означает его обратную трассировку (Процесс пошагового выполнения программы).
                    ioException.printStackTrace();
                }
            }
        });

        // Здесь можно будет создать изображение
        JMenuItem img_menu_item = new JMenuItem("Image (decorative)");

        // Здесь можно будет создать аудио
        JMenuItem music_menu_item = new JMenuItem("Music (decorative)");
        file_menu.add(new_menu);
        new_menu.add(text_menu_item);
        new_menu.add(music_menu_item);
        new_menu.add(img_menu_item);

        // Открытие файла

        JMenuItem open_menu_item = new JMenuItem("Open recent");
        open_menu_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String[] path_file = {""};
                //указание пути
                JFrame f1 = new JFrame();
                f1.setSize(250, 100);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setLocationRelativeTo(null);
                f1.setLayout(new GridLayout(2, 1));
                JTextField field = new JTextField(System.getProperty("user.dir") + "\\" + file_name + ".txt");
                f1.add(field);
                JButton butOK = new JButton("ОК");
                f1.add(butOK);
                butOK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        path_file[0] = field.getText();
                        f1.setVisible(false);
                        if (path_file[0].contains(".txt")) {
                            try {
                                workWithTextFile(f, path_file[0]);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                });
                f1.setVisible(true);

            }
        });

        // Сохранение файла

        JMenuItem save_menu_item = new JMenuItem("Save");
        save_menu_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (area.isVisible()) {
                    try (FileWriter writer = new FileWriter(file_name + ".txt", false)) {
                        writer.write(area.getText());
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });


        // Выход
        JMenuItem exit_menu_item = new JMenuItem("Close");

        exit_menu_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.setJMenuBar(bar);
            }
        });
        file_menu.add(open_menu_item);
        file_menu.add(save_menu_item);
        window_menu.add(exit_menu_item);

        f.setJMenuBar(bar);
        f.setVisible(true);
    }
}

