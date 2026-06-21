package testCollection.practice_questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordList {
    public static void main(String[] args) {

        record Employee(String name, String department, double salary, int age) {
        }

        final List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Alice", "Engineering", 95000, 30),
                new Employee("Bob", "Marketing", 60000, 45),
                new Employee("Carol", "Engineering", 110000, 35),
                new Employee("David", "HR", 55000, 28),
                new Employee("Eve", "Marketing", 72000, 38),
                new Employee("Frank", "Engineering", 88000, 42),
                new Employee("Grace", "HR", 62000, 31),
                new Employee("Hank", "Finance", 98000, 50)
        ));


//  1. Quest - group them by their first letter and return a Map<Character, List<String>> where each list is sorted by length descending, then alphabetically.
        List<String> words = new ArrayList<>(List.of("apple", "banana", "cherry", "avocado"));
        Collector<String, Object, List<String>> downstream = Collectors.collectingAndThen(
                Collectors.toList(), list -> list.stream()
                        .sorted(Comparator.comparingInt(String::length)
                                .reversed()
                                .thenComparing(Comparator.naturalOrder()))
                        .collect(Collectors.toList())
        );
        Map<Character, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(
                        x -> x.charAt(0), downstream));

//  2. partition into two groups (even/odd), and within each group, return only the squares of numbers greater than 3. Result type: Map<Boolean, List<Integer>>.
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Map<Boolean, List<Integer>> collect1 = nums.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.collectingAndThen(
                                        Collectors.toList(), z -> z.stream()
                                                .map(x -> x * x)
                                                .filter(y -> y > 3)
                                                .toList()
                                )
                        )
                );

//  3.  return the second-highest-paid employee in each department. If a department has only one employee, exclude it.

        Collector<Employee, Object, Double> transformsScndHgstSalariesByDepartment = Collectors.collectingAndThen(
                Collectors.toList(),
                z -> z.stream()
                        .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                        .map(Employee::salary)
                        .skip(1)
                        .findFirst()
                        .orElse(null)
        );
        Map<String, Double> collect2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, transformsScndHgstSalariesByDepartment))
                .entrySet()
                .stream()
                .filter(x -> Objects.nonNull(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

//  5. Given List<String> sentences, return a Map<String, Long> of word → frequency across all sentences (case-insensitive, ignore punctuation),
//  sorted by frequency descending, then alphabetically. Result must preserve order — use LinkedHashMap.

        List<String> sentences = List.of(
                "The quick brown fox",
                "The lazy dog",
                "A quick fox jumps"
        );

        Map<String, Long> collect3 = sentences.stream()
                .map(x -> x.toLowerCase().split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

//  6.

    }
}