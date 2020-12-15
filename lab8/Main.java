package Lab_8;

public class Main {
    public static void main(String[] args) {
        FileEditor fileEditor = new FileEditor("text.txt");
        fileEditor.write(false);
        fileEditor.read_all();
        fileEditor.write(true);
        fileEditor.read_all();

    }
}
