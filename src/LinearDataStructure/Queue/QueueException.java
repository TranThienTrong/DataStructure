package LinearDataStructure.Queue;

public class QueueException extends Exception{
    public String QueueOverflow() {
        return "Queue Full";
    }

    public String QueueEmpty() {
        return  "Empty Queue";
    }

}
