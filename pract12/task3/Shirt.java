package pract14.task3;

public class Shirt {

    private int index;
    private String name;
    private String color;
    private String size;


    public Shirt(int index, String name, String color, String size) {
        this.index = index;
        this.name = name;
        this.color = color;
        this.size = size;
    }


    public static Shirt fromString(String src) throws IllegalArgumentException {
        String[] fields = src.split(",");

        if (fields.length != 4)
            throw new IllegalArgumentException();

        fields[0] = fields[0].replace('S', '0');

        return new Shirt(
                Integer.parseInt(fields[0]),
                fields[1],
                fields[2],
                fields[3]
        );
    }

    public String toString() {
        return "Shirt{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
