package ru.chalovai.PR12;

import java.io.IOException;

public class CreateTextDocument implements AbstractFactory {

    @Override
    public IDocument createDoc(String type, String name) throws IOException {
        return switch (type) {
            case "text" -> new TextDocument(name);
            case "image" -> new ImageDocument(name);
            case "music" -> new MusicDocument(name);
            default -> null;
        };
    }
}
