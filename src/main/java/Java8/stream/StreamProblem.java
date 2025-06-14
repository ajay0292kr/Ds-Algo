package Java8.stream;
import java.util.*;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge() {
    }
}
class Transaction {
    private String date;
    private Integer amount;

    public Transaction(String date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
}
public class StreamProblem {
    public static void main(String[] args) {
        //  Find the longest string in a list of strings using Java streams:
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        Optional<String> longestString = strings.stream().max(Comparator.comparingInt(String::length));
        longestString.ifPresent(s -> System.out.println("Longest string: " + s));

        //  Calculate the average age of a list of Person objects using Java streams:
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        double averageAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.print(averageAge);

        //  Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.print(mergedList);

        // Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = list3.stream()
                .filter(list4::contains)
                .collect(Collectors.toList());
        System.out.print(intersection);

        //  Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> removingDuplicate = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(removingDuplicate);

        // Given a list of transactions, find the sum of transaction amounts for each day using Java streams:

        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        // Map<String, Integer> sumByDay = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));

        // Find the kth smallest element in an array using Java streams:

        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        int kthSmallest = Arrays.stream(array).sorted().skip(k - 1).findFirst().orElse(-1);
        System.out.print(kthSmallest);

        // Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> frequencyMap = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.print(frequencyMap);

        // Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers
                .stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);

        // How do you handle null values in Java streams?
        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> filteredList = list.stream().map(e -> {
            if (e == null) {
                return "N/A";
            }
            return e.toUpperCase();
        }).collect(Collectors.toList());

        List<Optional<String>> optionalList = list.stream()
                .map(Optional::ofNullable)
                .collect(Collectors.toList());

        List<String> list6 = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> nonNullList = list6.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // Concatenate all the strings in a list into a single string.
        List<String> words1 = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        String str = String.join("", words1);
        System.out.print(str);

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String joinedString = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.print(joinedString);

        // How do you merge two unsorted arrays into single sorted array without duplicates?
        int[] a = new int[]{4, 2, 5, 1};
        int[] b = new int[]{8, 1, 9, 5};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);

        // Java 8 program to check if two strings are anagrams or not?
        String s1 = "RaceCar";
        String s2 = "CarRace";

        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        // find the sum of all digit of a number
        int i = 15623;

        Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();

        // Find second largest number in an integer array?
        List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Integer largest  = listOfIntegers2.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.print(largest);

        //  Given a list of strings, sort them according to increasing order of their length?

        List<String> listOfStrings4 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStrings4.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::print);

        // Find the sum and average of below array
        int[] arr = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int sum  = Arrays.stream(arr).sum();
        //Optional<Double> avg = Optional.of(Arrays.stream(arr).average()).ifPresent();

        // Steps to sort map
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);

        Map<String, Integer> result_1 = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) ->  k, LinkedHashMap::new));
        System.out.print(result_1);

        //Alternative way
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
      /*  Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> oldValue
                )
        );*/

        Map<Integer, String> map_4 = new HashMap<>();
        map_4.put(1, "linode");
        map_4.put(2, "heroku");
        map_4.put(3, "aws");

        String result1 = map_4.values().stream().filter("linode"::equals).collect(Collectors.joining());
        System.out.print(result1);

    }
}
