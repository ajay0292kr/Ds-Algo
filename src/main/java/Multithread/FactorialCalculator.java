package Multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

    private int number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if(number == 0 || number == 1) {
            return 1;
        }
        else {
            for(int i = 2; i<=number; i++) {
                result *=i;
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }
}
