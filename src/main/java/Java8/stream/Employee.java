package Java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Org {

}
class Team {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return new ArrayList<>();
    }
}
class Department {
    private List<Project> projectList;
}
class Project {
    private List<Employee> employeeList;
    public List<Employee> getEmployeeList() {
        return new ArrayList<>();
    }
}
class Student {

}
class School {
    List<Class> classList;

    public List<Class> getClassList() {
        return new ArrayList<>();
    }
}
class Class {
    List<Student> studentList;
    public List<Student> getStudentList() {
        return new ArrayList<>();
    }
}

/* You have a Map<Department, List<Project>>, where:

Department contains the department details and a list of projects assigned to it.
Project contains details of the project, including a list of Employees working on it.

Write a stream operation to convert Map<Department, List<Project>> into Map<Department, List<Employee>>,
where each Department maps to a list of all Employees working on its projects. */

public class Employee {
    public static Map<Org, List<Employee>> convertOrgTeamsToOrgEmployees(Map<Org, List<Team>> orgTeamsMap) {
        return orgTeamsMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Keep the Org as the key
                        entry -> entry.getValue() // List<Team> for each Org
                                .stream()
                                .flatMap(team -> team.getEmployees().stream()) // Flatten List<Team> to List<Employee>
                                .collect(Collectors.toList()) // Collect into List<Employee>
                ));
    }
    public static Map<Department, List<Employee>> convertEmp(Map<Department, List<Project>> departmentListMap) {
        return departmentListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()
                .stream().flatMap(project -> project.getEmployeeList().stream()).collect(Collectors.toList())));
    }

    /*
       Question 2 Implementation You have a List<School>, where:
       Each School has a list of Classes. Each Class has a list of Students.

     */
    public static List<Student> getAllStudents(List<School> schools) {
        return schools.stream()
                .flatMap(school -> school.getClassList().stream()) // Flatten List<School> to List<Class>
                .flatMap(clazz -> clazz.getStudentList().stream()) // Flatten List<Class> to List<Student>
                .collect(Collectors.toList()); // Collect into a single List<Student>
    }
    public static void main(String[] args) {

    }
}
