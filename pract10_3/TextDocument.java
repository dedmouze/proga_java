package ru.chalovai.PR12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextDocument implements IDocument{

    TextDocument() throws IOException {
        Files.createFile(Path.of(System.getProperty("user.dir")+ "\\file.txt"));
    }

    TextDocument(String name) throws IOException {
        name += ".txt";
        Files.createFile(Path.of(System.getProperty("user.dir")+ "\\" + name));
    }
}
