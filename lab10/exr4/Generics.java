
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generics<E> {
    //№1
    //формируем из массива список
    public List<E> arrayToList(E[] arr){
        List<E> list = Arrays.asList(arr);
        return list;
    }
    //№2
    //массив любых элементов
    private E[] arr;

    public E[] getArr() {
        return arr;
    }

    public void setArr(E[] arr) {
        this.arr = arr;
    }

    //№3
    //метод, который возвращает любой элемент массива по индексу
    public E get(int index){
        return arr[index];
    }

    //№4
    //функция, которая сохранит содержимое каталога в список и выведет первые 5 элементов на экран
    public List<Path>getList() throws IOException {
        Stream<Path> stream = Files.list(Paths.get("."));
        List<Path> list = stream.collect(Collectors.toList());

        for (int i = 0; i < 5; i++){
            if (i > list.size()-1)
                break;
            System.out.print(list.get(i));
        }
        return list;
    }
}