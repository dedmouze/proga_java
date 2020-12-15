package pract8;

public class UnfairWaitList<T> extends WaitList<T>{
    UnfairWaitList(){
        super();
    }

    public void remove(T element){
        if (element != null)
            content.remove(element);
    }

    public void moveToBack(){
        T peek = super.content.remove();
        super.content.add(peek);
    }

    public String toString(){
        return "Your UnfairList: " + content;
    }
}
