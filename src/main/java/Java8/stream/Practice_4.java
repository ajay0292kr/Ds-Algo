package Java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice_4 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);

        double avgSum = nums.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(avgSum);

        //Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        String str[] = {"mango", "apple", "orange"};
        List<String> res = Stream.of(str).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(res);

        // Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int evenSum = numbers.stream().mapToInt(Integer::intValue).filter(e->e%2 ==0).sum();
        System.out.println(evenSum);

        int oddSum = numbers.stream().mapToInt(Integer::intValue).filter(e->e%2 !=0).sum();
        System.out.println(oddSum);

        // Write a Java program to remove all duplicate elements from a list using streams.
        List < Integer > nums2 = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
        List<Integer> remove = nums2.stream().distinct().collect(Collectors.toList());
        System.out.println(remove);

        //  Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        List<Integer> sortNumberAsc = nums2.stream().sorted().collect(Collectors.toList());
        System.out.println(sortNumberAsc);

        List<Integer> sortedReverseOrder = nums2.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedReverseOrder);

        // Write a Java program to find the maximum and minimum values in a list of integers using streams.
        int maxValue = nums2.stream().max(Integer::compare).orElse(null);
        System.out.println(maxValue);

        Integer min_val = nums.stream()
                .min(Integer::compare)
                .orElse(null);
        System.out.println(min_val);
        //  Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        List<Integer> secondHighest = nums2.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(secondHighest.get(0));
        List<Integer> smallest = nums2.stream().sorted().distinct().skip(1).limit(1).collect(Collectors.toList());
        System.out.println(smallest.get(0));

        // Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers2
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);

        // Frequency of each character in string.
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> charCountMap =
                inputString.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String joinedString = listOfStrings.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedString);
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        int max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        int min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();

        int[] a = new int[] {4, 2, 7, 1};
        int[] b = new int[] {8, 3, 9, 5};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(c));

        int i = 15623;
        Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sumOfDigits);

        Integer secondLargestNumber = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        List<String> listOfStrings_1 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStrings_1.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        int[] ar = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int sum = Arrays.stream(ar).sum();
        System.out.println("Sum = "+sum);
        double average = Arrays.stream(ar).average().getAsDouble();
        System.out.println("Average = "+average);

        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);

        String str_4 = "Java Concept Of The Day";

        String reversedStr = Arrays.stream(str_4.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));

        List<String> strings = Arrays.asList("hello", "world", "java", "stream");
        Optional<Map.Entry<Character, Long>> mostOccurringChar = strings.stream().flatMapToInt(String::chars).mapToObj(v -> (char)v)
                        .collect(Collectors.groupingBy(p->p, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());

        System.out.println(reversedStr);


    }
}
