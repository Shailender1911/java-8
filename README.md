Here are **advanced Java 8 interview questions with answers**, categorized for a **Senior Software Engineer** role:

---

### **1. Lambda Expressions and Functional Interfaces**
**Q: What are lambda expressions, and how do they simplify code in Java 8?**  
**A:** Lambda expressions provide a concise way to write anonymous functions. They simplify code by reducing boilerplate code required for implementing functional interfaces.  
Example:  
```java
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.forEach(name -> System.out.println(name));
```

---

**Q: Difference between Lambda and Anonymous Class?**  
**A:** 
- Lambda expressions are more concise and easier to read.  
- Anonymous classes can implement multiple methods; lambdas can only implement one method from a functional interface.

---

**Q: Can a functional interface have multiple default methods?**  
**A:** Yes, functional interfaces can have multiple `default` methods but only **one abstract method**.  

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void performAction(); // Abstract Method

    default void showMessage() {
        System.out.println("Default Method");
    }
}
```

---

### **2. Streams API**
**Q: Difference between `map()` and `flatMap()`?**  
**A:** 
- `map()` transforms elements individually.  
- `flatMap()` transforms and flattens nested collections.  

```java
List<List<String>> nestedList = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"));
List<String> flattenedList = nestedList.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList()); // Output: [A, B, C, D]
```

---

**Q: What is the difference between `forEach()` and `collect()`?**  
**A:** 
- `forEach()` is a terminal operation for iterating through elements.  
- `collect()` is used for collecting elements into a collection.  

```java
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.stream().forEach(System.out::println); // Print all names
List<String> uppercaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
```

---

### **3. Optional Class**
**Q: What is the purpose of `Optional`?**  
**A:**  
`Optional` helps handle `null` values safely without explicit `null` checks, reducing `NullPointerException`.  

```java
Optional<String> optionalName = Optional.ofNullable(null);
System.out.println(optionalName.orElse("Default Value"));
```

---

**Q: Difference between `Optional.of()`, `Optional.ofNullable()` and `Optional.empty()`?**  
**A:**  
- `Optional.of()` → Throws an exception if the value is `null`.  
- `Optional.ofNullable()` → Allows `null`.  
- `Optional.empty()` → Represents an empty `Optional`.

```java
Optional<String> empty = Optional.empty();
Optional<String> nonNull = Optional.of("Hello");
Optional<String> nullable = Optional.ofNullable(null);
```

---

### **4. Method References**
**Q: Explain the types of method references with examples.**  
**A:**  
- **Static Method Reference:** `Class::staticMethod`  
- **Instance Method Reference:** `instance::method`  
- **Constructor Reference:** `Class::new`

```java
Function<String, Integer> strLength = String::length;
Supplier<List<String>> listSupplier = ArrayList::new;
```

---

### **5. Built-in Functional Interfaces**
**Q: What are the main functional interfaces introduced in Java 8?**  
**A:**  
- **Predicate:** Represents a boolean condition.  
- **Function:** Takes an argument and produces a result.  
- **Supplier:** Provides a value without any input.  
- **Consumer:** Accepts a value and performs an action.  

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
Function<String, Integer> stringLength = String::length;
Supplier<String> supplier = () -> "Hello";
Consumer<String> consumer = System.out::println;
```

---

### **6. Date and Time API (`java.time`)**
**Q: How is the Date and Time API better than `java.util.Date`?**  
**A:**  
- **Immutable and Thread-Safe.**  
- **Clearer API Design.**  
- **Supports Time Zones.**

```java
LocalDate today = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
System.out.println("Today: " + today + ", Time: " + time);
```

---

**Q: How to format a `LocalDateTime` using `DateTimeFormatter`?**  
```java
LocalDateTime now = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
String formattedDate = now.format(formatter);
System.out.println(formattedDate);
```

---

### **7. Concurrency Enhancements**
**Q: What is `CompletableFuture` and how to use it?**  
**A:**  
`CompletableFuture` allows asynchronous programming with non-blocking code.  

```java
CompletableFuture.supplyAsync(() -> "Task Completed")
                 .thenAccept(System.out::println);
```

---

**Q: Difference between `join()` and `get()`?**  
**A:**  
- `get()` throws `ExecutionException` and `InterruptedException`.  
- `join()` only throws unchecked exceptions.  

---

### **8. Collectors and Reduction**
**Q: Explain `Collectors.groupingBy()` and `partitioningBy()`.**  
**A:**  
- **groupingBy()** → Groups elements based on a classifier function.  
- **partitioningBy()** → Divides elements into two groups based on a condition.  

```java
List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");
Map<Character, List<String>> grouped = names.stream()
    .collect(Collectors.groupingBy(name -> name.charAt(0)));

Map<Boolean, List<String>> partitioned = names.stream()
    .collect(Collectors.partitioningBy(name -> name.startsWith("J")));
```

---

**Q: How to find the maximum value using Streams?**  
```java
List<Integer> numbers = Arrays.asList(1, 3, 7, 4, 5);
int max = numbers.stream().max(Integer::compare).orElse(-1);
System.out.println("Max: " + max);
```

Here are **20 advanced Java 8 coding questions with solutions**, ideal for a **Senior Software Engineer** interview:

---

### **1. Find the Second Highest Number in a List**
```java
List<Integer> numbers = Arrays.asList(1, 5, 2, 9, 8, 7);
int secondHighest = numbers.stream()
    .distinct()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst()
    .orElseThrow(() -> new RuntimeException("Not enough elements"));
System.out.println("Second Highest: " + secondHighest);
```

---

### **2. Find the Frequency of Each Element in a List**
```java
List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana");
Map<String, Long> frequencyMap = items.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
System.out.println(frequencyMap);
```

---

### **3. Check If a List Contains a Specific Value**
```java
List<String> names = Arrays.asList("John", "Jane", "Jack");
boolean exists = names.stream().anyMatch(name -> name.equals("Jane"));
System.out.println("Exists: " + exists);
```

---

### **4. Reverse a List Using Streams**
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> reversed = list.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
System.out.println("Reversed: " + reversed);
```

---

### **5. Remove Duplicates from a List**
```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
List<Integer> unique = numbers.stream()
    .distinct()
    .collect(Collectors.toList());
System.out.println("Unique Elements: " + unique);
```

---

### **6. Find the Sum of All Even Numbers**
```java
int sumOfEvens = IntStream.rangeClosed(1, 10)
    .filter(n -> n % 2 == 0)
    .sum();
System.out.println("Sum of Evens: " + sumOfEvens);
```

---

### **7. Check If a List is Palindrome**
```java
List<String> words = Arrays.asList("level", "radar", "hello");
boolean isPalindrome = words.stream()
    .allMatch(word -> word.equals(new StringBuilder(word).reverse().toString()));
System.out.println("Is Palindrome: " + isPalindrome);
```

---

### **8. Find the Longest String in a List**
```java
List<String> names = Arrays.asList("John", "Alexander", "Emma");
String longest = names.stream()
    .max(Comparator.comparingInt(String::length))
    .orElse("No Data");
System.out.println("Longest Name: " + longest);
```

---

### **9. Convert a List of Strings to Uppercase**
```java
List<String> names = Arrays.asList("john", "jane", "jack");
List<String> upperCaseNames = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
System.out.println(upperCaseNames);
```

---

### **10. Flatten a List of Lists**
```java
List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
List<Integer> flatList = nestedList.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
System.out.println("Flattened List: " + flatList);
```

---

### **11. Group Numbers by Even and Odd**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Map<Boolean, List<Integer>> grouped = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
System.out.println(grouped);
```

---

### **12. Count Vowels in a String**
```java
String str = "Hello World";
long vowelCount = str.toLowerCase().chars()
    .filter(c -> "aeiou".indexOf(c) != -1)
    .count();
System.out.println("Vowel Count: " + vowelCount);
```

---

### **13. Find the First Non-Repeated Character in a String**
```java
String input = "swiss";
Character result = input.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
    .entrySet().stream()
    .filter(entry -> entry.getValue() == 1)
    .map(Map.Entry::getKey)
    .findFirst()
    .orElse(null);
System.out.println("First Non-Repeated Character: " + result);
```

---

### **14. Generate a List of Fibonacci Numbers**
```java
Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
    .limit(10)
    .map(f -> f[0])
    .forEach(System.out::println);
```

---

### **15. Calculate Factorial Using Streams**
```java
int factorial = IntStream.rangeClosed(1, 5)
    .reduce(1, (a, b) -> a * b);
System.out.println("Factorial: " + factorial);
```

---

### **16. Convert a List to a Map (Key: Value Length)**
```java
List<String> names = Arrays.asList("John", "Jane", "Jack");
Map<String, Integer> nameLengthMap = names.stream()
    .collect(Collectors.toMap(Function.identity(), String::length));
System.out.println(nameLengthMap);
```

---

### **17. Find Common Elements Between Two Lists**
```java
List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
List<Integer> common = list1.stream()
    .filter(list2::contains)
    .collect(Collectors.toList());
System.out.println("Common Elements: " + common);
```

---

### **18. Find the nth Element of a List Using Stream**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int n = 3;
int nthElement = numbers.stream()
    .skip(n - 1)
    .findFirst()
    .orElse(-1);
System.out.println("3rd Element: " + nthElement);
```

---

### **19. Find the Most Frequent Element in a List**
```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
int mostFrequent = numbers.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .get().getKey();
System.out.println("Most Frequent: " + mostFrequent);
```

---

### **20. Check If All Elements in a List Are Positive**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
boolean allPositive = numbers.stream().allMatch(n -> n > 0);
System.out.println("All Positive: " + allPositive);
```
