package Lab_8;

import java.io.*;
import java.util.Scanner;

public class FileEditor {

    File file;
    FileEditor(String path){
        this.file = new File(path);
    }

    public void read_all(){
        try (FileReader reader = new FileReader(file)){
            Scanner scan = new Scanner(reader);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    public void write(boolean append){
        try (FileWriter writer = new FileWriter(file, append)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text=reader.readLine();
            writer.write(text);
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
