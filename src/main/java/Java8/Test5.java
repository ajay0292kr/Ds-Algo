package Java8;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
class Employee1 {
    private int age;
    private int salary;
    private String department;
    public Employee1() {

    }
    public Employee1(int age, int salary, String department) {
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }
    public String getDepartment() {
        return department;
    }

}
public class Test5 {
    public static void main(String[] args) {
        List<Employee1> emp = new ArrayList<>();

        Employee1 e1 = new Employee1(12, 2000, "HR");
        Employee1 e2 = new Employee1(13, 3000, "FINANCE");
        Employee1 e3 = new Employee1(20, 1500, "IT");
        Employee1 e4 = new Employee1(21, 1600, "IT");
        Employee1 e5 = new Employee1(18, 5000, "FINANCE");

        emp.add(e1);
        emp.add(e2);
        emp.add(e3);
        emp.add(e4);
        emp.add(e5);

        //List<Employee> maxSalary = emp.stream().sort(Comparator.comparingInt(o1.getSalary() - o2.getSalary())).
        //collect(Collectors.toList());
        List<Employee1> maxSalary = emp.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).collect(Collectors.toList());
        System.out.println(maxSalary.get(0).getSalary());

        Map<String, Double> avgSalary = emp.stream().collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.averagingDouble(Employee1::getSalary)));
        for(Map.Entry<String, Double> empS: avgSalary.entrySet()) {
            System.out.println(empS.getKey() +"===="+ empS.getValue());
        }
    }
}