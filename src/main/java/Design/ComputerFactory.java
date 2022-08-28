package Design;

public class ComputerFactory {
    public static FactoryDesignComputer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type)) return new FactoryPC(ram, hdd, cpu);
        else if("Server".equalsIgnoreCase(type)) return new FactoryServer(ram, hdd, cpu);

        return null;
    }
}
