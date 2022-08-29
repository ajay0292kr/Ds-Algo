package oops;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Java Reflections use
public class EmployeeTest {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       Employee emp = new Employee();
       Method method = Employee.class.getDeclaredMethod("getAll", String.class);
       method.setAccessible(true);
       String data = "Ajay@Kumar@Thakur";
       method.invoke(emp, data);
    }

}
