package ru.home.funcProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Methods {
    static void SimpleTask() {
        List<Person> pers = new ArrayList<>(Arrays.asList(
                new Person("Bob", 35, Person.Position.MANAGER),
                new Person("John", 44, Person.Position.DIRECTOR),
                new Person("Steve", 25, Person.Position.ENGINEER),
                new Person("Mike", 42, Person.Position.ENGINEER),
                new Person("Pol", 55, Person.Position.MANAGER),
                new Person("Jack", 19, Person.Position.MANAGER),
                new Person("Tony", 33, Person.Position.ENGINEER),
                new Person("Bill", 37, Person.Position.MANAGER)
        ));

        // persons.stream().filter(person -> person.position == Person.position.ENGINEER)
        List<Methods.Person> managers = new ArrayList<>();
        for (Person person : pers) {
            if (person.position == Person.Position.MANAGER) {
                managers.add(person);
            }
        }

        // persons.stream()./.sorted((o1, o2) -> o1.age - o2.age)
        managers.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.age - person2.age;
            }
        });
        // persons.stream().//.map(person -> person.name)
        List<String> managersNames = new ArrayList<>();
        for (Person person : managers) {
            managersNames.add(person.name);
        }
        System.out.println(managersNames);
    }

    static void streamSimpleTask() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob", 35, Person.Position.MANAGER),
                new Person("John", 44, Person.Position.DIRECTOR),
                new Person("Steve", 25, Person.Position.ENGINEER),
                new Person("Mike", 42, Person.Position.ENGINEER),
                new Person("Pol", 55, Person.Position.MANAGER),
                new Person("Jack", 19, Person.Position.MANAGER),
                new Person("Tony", 33, Person.Position.ENGINEER),
                new Person("Bill", 37, Person.Position.MANAGER)
        ));

        List<String> engineersNames = persons.stream()
                .filter(person -> person.position == Person.Position.ENGINEER)
                .sorted((person1, person2) -> person1.age - person2.age)
                .map(person -> person.name)
                .collect(Collectors.toList());
        System.out.println((engineersNames));
    }

    static void streamCheckInfoTask() {
        List<AnotherPerson> anotherPersons = Arrays.asList(
                new AnotherPerson("Andrew", 20),
                new AnotherPerson("Igor", 23),
                new AnotherPerson("Ira", 23),
                new AnotherPerson("Victor", 29)
        );

        anotherPersons
                .parallelStream()
                .reduce(0, (sum, p) -> {
                    System.out.printf("accum: sum=%s; person=%s [%s]\n", sum, p.name, Thread.currentThread().getName());
                    return sum += p.age;
                }, (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s: sum2=%s [%s]\n", sum1, sum2, Thread.currentThread().getName());
                    return sum1 + sum2;
                });
    }

    static class Person {
        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }

        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }
    }

    static class AnotherPerson {

        private String name;
        private int age;

        public AnotherPerson(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
