package Model;

public interface Notifier {
    public void subscribe(Reciever r, String event);
}
