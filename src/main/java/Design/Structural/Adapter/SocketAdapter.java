package Design.Structural.Adapter;

public interface SocketAdapter {
    public Volt get120Volt();

    public Volt get12Volt();

    public Volt get3Volt();
}

// Two Way Adapter Pattern
// Class Adapter  -> inheritance
// Object Adapter -> Object Adapter

