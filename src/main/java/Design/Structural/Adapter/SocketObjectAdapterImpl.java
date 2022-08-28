package Design.Structural.Adapter;

// Here is the Object adapter implementation of our adapter.
public class SocketObjectAdapterImpl implements SocketAdapter {
    //Using Composition for adapter pattern
    private Socket sock = new Socket();

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v= sock.getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3Volt() {
        Volt v= sock.getVolt();
        return convertVolt(v,40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }

    /*
       Notice that both the adapter implementations are almost same and they
       implement the SocketAdapter interface. The adapter interface can also
       be an abstract class. Here is a test program to consume our adapter design
       pattern implementation.
     */
}
