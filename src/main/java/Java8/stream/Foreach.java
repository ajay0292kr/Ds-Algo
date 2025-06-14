package Java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Foreach {
    public static void main(String[] args) {
        String[] names = {"Java", "Node", "JavaScript", "Rust", "Go"};
        List<String> collect = IntStream.range(0, names.length).mapToObj(index -> index+":"+ names[index]).collect(Collectors.toList());
        System.out.println(collect);

        List<String> list = Arrays.asList("Java", "Node", "JavaScript", "Rust", "Go");
        /*HashMap<Integer, String> collect1 = list.stream().collect(HashMap<Integer, String>::new, (map, streamValue) -> map.put(map.size(), streamValue)),
        (map, map2) -> {};*/
        List<String> list3 = Arrays.asList("a", "b", "c", "d", "e");
        String str = list3.stream().filter(x -> x.length() ==1).findFirst().map(Object::toString).orElse("");
        System.out.print(str);

        List<String> list4 = Arrays.asList("a", "b", "c", "d", "e");
        Optional<String> str2 = list4.stream().filter(x -> x.length() == 1).findFirst();
        str2.ifPresent(System.out::println);

        String str3 = list4.stream().filter(x -> x.length() == 1).findFirst().map(Object::toString).orElse("");
        System.out.println(str3);

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).reduce(0, (a,b) -> a + b);
        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);
        int sum3 = Arrays.stream(numbers).reduce(0, (a,b) -> a-b);
        int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a*b);
        int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > 0 ? a:b);
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);
        int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < 0 ? a: b);
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);

        String[] strings = {"a", "b", "c", "d", "e"};
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a+"|"+b);
        String reduce2 = Arrays.stream(strings).reduce("", (a , b) -> {
            if (!"".equals(a)) {
                return a +"|" +b;
            }else {
                return b;
            }
        });
        String join = String.join("|", strings);

    }
}
