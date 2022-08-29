package Stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NullExmaple {
    public static void main(String[] args) {
        Stream<String> str = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> result = str.collect(Collectors.toList());
        result.forEach(System.out::println);

        List<String> result1 = str.filter(Objects::nonNull).collect(Collectors.toList());
        
        List<String> nullCheck = str.filter(Objects::nonNull).collect(Collectors.toList());
        result1.forEach(System.out::println);
    }
}
