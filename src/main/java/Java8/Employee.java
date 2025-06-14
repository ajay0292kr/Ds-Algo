package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {
    private int id;

    private String name;

    private int age;

    private String gender;

    private String department;

    private int yearOfJoining;

    private double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }
    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new Employee(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new Employee(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new Employee(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new Employee(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new Employee(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new Employee(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new Employee(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new Employee(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new Employee(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new Employee(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new Employee(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));


        // 1. How many employees are there in the organization?
        long count = employeeList.stream().collect(Collectors.counting());
        System.out.print("count = "+ count);

        //  Sort the List of Employee objects based on salary in Ascending order
        List<Employee> employeesSortedList1 = employeeList.stream().sorted(Comparator.comparingInt(o -> (int) o.getSalary())).collect(Collectors.toList());
        System.out.print(employeesSortedList1);

        // Sort the List of Employee objects based on salary in Descending order
        List<Employee> employeesSortedList2 = employeeList.stream().sorted((o1, o2) -> ((int) (o2.getSalary() - o1.getSalary())))
                .collect(Collectors.toList());

        System.out.print(employeesSortedList2);

        // How many male and female employees are there in the organization?
        Map<String, Long> genderMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("No of male & female Employees : "+ genderMap);

        // How many employees are there in each department?
        Map<String, Long> noOfEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.print(noOfEmployee);

        // Get the name of all the department
        List<String> departmentName = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.print(departmentName);

        // Find the average salary of the male and female employee
        Map<String, Double> avgSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.print(avgSalary);

        // Fetch the highest-paid male and female employee
        Map<String, Optional<Employee>> highestPaid = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
        System.out.print(highestPaid);

        // Fetch the lowest-paid male and female employee
        Map<String, Optional<Employee>> minPaid = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
        System.out.print(minPaid);

        // Get the details of the highest paid employee in the organization?
        Optional<Employee> highestPaidEmployeeWrapper= employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));

        // Get the details of youngest male employee in the product development department?
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper =
                employeeList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));
        System.out.print(youngestMaleEmployeeInProductDevelopmentWrapper);

        // Who has the most working experience in the organization?
        Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
        System.out.print(seniorMostEmployeeWrapper);
        // How many male and female employees are there in the sales and marketing team?
        Map<String, Long> maleFemaleEmployee = employeeList.stream().filter(e->e.getDepartment() =="Sales And Marketing").
                collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.print(maleFemaleEmployee);

        // What is the average salary of male and female employees?
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryOfMaleAndFemaleEmployees);
        //  : List down the names of all employees in each department?
        Map<String, List<Employee>> employeeListByDepartment=
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.print(employeeListByDepartment);

        // What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics employeeSalaryStatistics =
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.print(employeeSalaryStatistics);

        // Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Employee>> partitionEmployeesByAge =
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        // Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.print(oldestEmployeeWrapper);

        String str = "aabbccdd";

        // Stream processing to count characters and create the desired output
      /*  String result = str.chars() // Convert string to IntStream
                .mapToObj(c -> (char) c) // Convert int to char
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Group by character and count
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + entry.getValue()) // Format as char + count
                .collect(Collectors.joining()); */ // Join all parts together

       // System.out.println(result); // Output: a2b2c2d2

        String str_2 = "hello world java";
        Stream<String> wordStream = Arrays.stream(str_2.split(" "));
        wordStream.forEach(System.out::println);
        return employeeList;
    }

    public static void main(String[] args) {

    }
}
