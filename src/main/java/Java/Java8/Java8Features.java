package Java.Java8;

public class Java8Features {
    /* 1. Lambda Expressions
       Introduced functional programming style into Java.
       Enables writing short, inline functions without creating separate classes.
     (parameter) -> expression.

      Before Java 8
       new Thread(new Runnable() {
         System.out.println("Hello");
       }).start();

       With java8
       new Thread(() -> System.out.println("Hello")).start();

       ✅ Benefit: Less boilerplate, cleaner code, easier concurrency.
     */

     /*
       2. Functional Interfaces
       An interface with exactly one abstract method.
       Annotated with @FunctionalInterface.
       Examples: Runnable, Callable, Comparator.
       You can pass them as lambda expressions.

       @FunctionalInterface
        interface Calculator {
            int operation(int a, int b);
        }

        Calculator add = (a, b) -> a + b;
        System.out.println(add.operation(5, 3));  // 8
      */

    /*
      3. Default & Static Methods in Interfaces
      Interfaces can now have default implementations.
      Allows adding new methods in interfaces without breaking existing implementations.

      interface Vehicle {
      default void start() {
         System.out.println("Starting vehicle...");
      }
      static void service() {
        System.out.println("Vehicle service...");
      }
     }
     ✅ Benefit: Eases evolution of APIs.
     */
    /*
      4. Method References
      Shorter syntax for calling an existing method via a lambda.
      Static Method → ClassName::methodName
      Instance Method → object::methodName
      Constructor → ClassName::new

      list.forEach(System.out::println);
     */
    /*
      5. Streams API
         The biggest feature of Java 8.
         Provides a functional, declarative way to process data (collections, arrays, I/O).
         Key operations:
              Intermediate (lazy): map(), filter(), sorted(), distinct(), limit()
              Terminal: collect(), forEach(), reduce(), count()

         Example
              List<String> names = Arrays.asList("Ajay", "Rohan", "Rahul");
                    names.stream()
                         .filter(n -> n.startsWith("R"))
                         .map(String::toUpperCase)
                         .forEach(System.out::println);
                    // Output: ROHAN, RAHUL
     */
    /*
      6. New Date & Time API (java.time)
         Old Date & Calendar were messy & mutable.
         New immutable API based on Joda-Time.

         Key Classes:
         LocalDate, LocalTime, LocalDateTime
         ZonedDateTime (time zones)
         Period & Duration (time differences)
         DateTimeFormatter
     */

    /*
       7. Optional Class
       Avoids NullPointerException.
       Represents optional values (may or may not be present).
       Optional<String> name = Optional.ofNullable(null);
       System.out.println(name.orElse("Default Name"));

       9. Parallel Array Sorting
       New method: Arrays.parallelSort()

Uses Fork/Join framework internally.
     */
  
   /* 1. APIs: https://lnkd.in/dsbwPZ6N
            2. API Gateways: https://lnkd.in/gtyXmvf4
            3. JWTs: https://lnkd.in/ghtXYRqU
            4. Webhooks: https://lnkd.in/geHxGX-7
            5. REST vs GraphQL: https://lnkd.in/gM5VHKQS
            6. Load Balancing: https://lnkd.in/gvxfwEUr
            7. Proxy vs Reverse Proxy: https://lnkd.in/gMTtidBq
            8. Scalability: https://lnkd.in/gPGhW-qK
            9. Availability: https://lnkd.in/gQk2p4_6
            10. SPOF: https://lnkd.in/gw_uHZWn
            11. CAP Theorem: https://lnkd.in/g_tFqJJb
            12. SQL vs NoSQL: https://lnkd.in/gHyC9qWc
            13. ACID Transactions: https://lnkd.in/dB3QHiMz
            14. Database Indexes: https://lnkd.in/g_-bQWtA
            15. Database Sharding: https://lnkd.in/g9mc-d5m
            16. Consistent Hashing: https://lnkd.in/gR9wFDpz
            17. CDC: https://lnkd.in/gWhGwh9Z
            18. Caching: https://lnkd.in/gBSeTstS
            19. Caching Strategies: https://lnkd.in/dVk7nZ_Y
            20. Cache Eviction Policies: https://lnkd.in/gQAEXEmq
            21. CDN: https://lnkd.in/gaW4Vkpy
            22. Rate Limiting Algorithms: https://lnkd.in/gYDxg8XY
            23. Message Queues: https://lnkd.in/g-jnNGDC
            24. Bloom Filters: https://lnkd.in/gfGjCrSZ
            25. Idempotency: https://lnkd.in/gDB3AJij
            26. Concurrency vs Parallelism: https://lnkd.in/gGZXhjBD
            27. Long Polling vs WebSockets: https://lnkd.in/d9xKD28K
            28. Stateful vs. Stateless Architecture: https://lnkd.in/gz_ccK-Y
            29. Batch vs Stream Processing: https://lnkd.in/gKtj_qWh
            30. Geohashing: https://lnkd.in/gjSbKdpN

    */
}
