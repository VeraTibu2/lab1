package Model;

public class Subscription {
    public Reciever reciever;

    public String event;

    Subscription(Reciever r, String e){
        reciever = r;
        event = e;
    }

}
