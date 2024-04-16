package ru.mirea.practices.practice_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Human> humans = Arrays.asList(
        new Human(25, "John", "Doe", LocalDate.of(1999, 5, 15), 60),
        new Human(30, "Jane", "Doe", LocalDate.of(1994, 8, 20), 75),
        new Human(22, "Abc", "Abc", LocalDate.of(2002, 3, 10), 55),
        new Human(35, "Aqwerty", "Aqwerty", LocalDate.of(1989, 12, 5), 70),
        new Human(41, "Jack", "Smith", LocalDate.of(1983, 11, 8), 80));

    System.out.println("Исходный список людей:");
    humans.forEach(System.out::println);

    List<Human> sortedByAgeDesc = humans.stream()
        .sorted((h1, h2) -> Integer.compare(h2.getAge(), h1.getAge()))
        .collect(Collectors.toList());
    System.out.println("\nСписок людей, отсортированный по возрасту в обратном порядке:");
    sortedByAgeDesc.forEach(System.out::println);

    List<Human> filteredByName = humans.stream()
        .filter(human -> human.getFirstName().startsWith("A"))
        .collect(Collectors.toList());
    System.out.println("\nСписок людей, имена которых начинаются с 'A':");
    filteredByName.forEach(System.out::println);

    List<Human> sortedByBirthDate = humans.stream()
        .sorted((h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()))
        .collect(Collectors.toList());
    System.out.println("\nСписок людей, отсортированный по дате рождения:");
    sortedByBirthDate.forEach(System.out::println);

    double averageWeight = humans.stream()
        .mapToInt(Human::getWeight)
        .average()
        .orElse(0.0);
    System.out.println("\nСредний вес всех людей: " + averageWeight);
  }
}
