import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;
public class Text10 {

    // Solve using JAVA8, Given String s = "nonreapeat" calculate the frequency of each character
    String s = "nonreapeat";
    Map<String, Long> freCount = Stream.of(s).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    //System.out.print(freCount);
}
