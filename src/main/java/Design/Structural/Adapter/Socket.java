package Design.Structural.Adapter;

public class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }
}
