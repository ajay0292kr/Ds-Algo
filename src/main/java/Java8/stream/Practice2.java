package Java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).peek(e -> resultSortedKey.add(e.getKey())).
                map(Map.Entry::getValue).filter(x -> !"banana".equalsIgnoreCase(x)).collect(Collectors.toList());
        System.out.print(resultValues);
        System.out.println(resultSortedKey);

        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");

        //java | python | nodejs | ruby
        String joiningString = String.join("|", list);
        String joinString = list.stream().collect(Collectors.joining("|"));
        System.out.println(joinString);
        System.out.print(joiningString);


    }
}
