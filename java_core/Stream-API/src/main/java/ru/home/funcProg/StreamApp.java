package ru.home.funcProg;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class StreamApp {
    public static void main(String[] args) {

        Methods.SimpleTask();

        Methods.streamSimpleTask();

//        Methods.streamCheckInfoTask();
//
//        // Create streams
//        List<String> list = new ArrayList<>(Arrays.asList("A", "AB", "B"));
//        Stream<String> stream = list.stream();
//        System.out.println(list);
//        System.out.println(Arrays.toString(stream.toArray()));
//
//        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
//        System.out.println((stream1));
//        System.out.println(Arrays.toString(stream1.toArray()));
//
//        String[] arr = {"C", "F", "G"};
//        Stream<String> stream2 = Arrays.stream(arr);
//        Stream<String> anotherStream = Stream.of(arr);
//        System.out.println(Arrays.toString(stream2.toArray()));
//        System.out.println(Arrays.toString(anotherStream.toArray()));
//
//        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
//        DoubleStream doubleStream = DoubleStream.of(1.23, 2.65, 5.78, 2);
//        IntStream intStream1 = IntStream.rangeClosed(1, 15);
//        System.out.println(Arrays.toString(intStream.toArray()));
//        System.out.println(Arrays.toString(longStream.toArray()));
//        System.out.println(Arrays.toString(doubleStream.toArray()));
//        System.out.println(Arrays.toString(intStream1.toArray()));
//
//        IntStream intStream2 = Stream.of(1, 2, 3, 4).mapToInt(n -> n);
//
//        IntStream intStream3 = Stream.of(1, 2, 3, 4).mapToInt(new ToIntFunction<>() {
//            @Override
//            public int applyAsInt(Integer n) {
//                return (int) Math.pow(n, 3);
//            }
//        });
//        System.out.println(Arrays.toString(intStream2.toArray()));
//        System.out.println(Arrays.toString(intStream3.toArray()));
//
//        // Base operations: terminal operations - collect()
//        Stream<String> stream3 = Stream.of("A", "B", "C");
//        Stream<String> stream4 = Stream.of("D", "E", "F");
//        List<String> list1 = stream3.collect(Collectors.toList());
//        System.out.println(list1);
//        Set<String> set = stream4.collect(Collectors.toSet());
//        Set<String> set1 = list1.stream().collect(Collectors.toSet());
//        Set<String> set2 = new HashSet<>(list1);
//        System.out.println(set);
//        System.out.println(set1);
//        System.out.println(set2);
//
//        String[] arr1 = {"Aaa", "Bbbbb", "Cc"};
//        System.out.println(Arrays.stream(arr1).collect(Collectors.averagingInt(s -> s.length())));
//
//        String[] arr2 = {"Aaa", "Bbbbb", "Cc", "Aa"};
//        System.out.println(Arrays.stream(arr2).filter(str -> str.startsWith("A")).collect(Collectors.joining(" и ", "Перечисленные слова [", "] начинаются на букву А")));
//
//        // Base operations: terminal operations - forEach()
//        Stream.of("a", "b", "c").forEach(str -> System.out.print(str));
//        set.stream().forEach(System.out::print);
//
//        // Base operations: terminal operations - count()
//        System.out.println("\n" + IntStream.rangeClosed(1, 20).count());
//
//        // Base operations: terminal operations - reduce()
//        IntStream.of(1, 2, 3, 24, 5, 6).reduce((i1, i2) -> i1 > i2 ? i1 : i2).ifPresent(System.out::println);
//        IntStream.of(1, 2, 3, 24, 5, 6).max().ifPresent(System.out::println);
//        System.out.println(IntStream.of(1, 2, 3, 24, 5, 6).max());
//        IntStream.of(1, 2, 3, 24, 5, 6).reduce((i1, i2) -> Math.max(i1, i2)).ifPresent(System.out::println);
//        System.out.println(IntStream.of(1, 2, 3, 24, 5, 6).sum());
//
//        // Base operations: intermediate operations - filter()
//        IntStream.rangeClosed(1, 9).filter(n -> n % 2 == 0).forEach(System.out::print);
//        System.out.println();
//
//        // Base operations: intermediate operations - distinct()
//        Stream.of("A", "A", "A", "A", "A", "B", "B", "B", "B", "B", "C", "C", "C", "C").distinct().forEach(System.out::print);
//        System.out.println();
//
//        // Base operations: intermediate operations - map()
//        Stream.of("Java", "Core", "Stream").map(str -> str.length()).forEach(System.out::print);
//        System.out.println();
//        Stream.of("Java", "Core", "Stream").map(String::length).forEach(str -> System.out.printf("%s ", str));
//        System.out.println();
//
//        // Base operations: intermediate operations - limit()
//        int[] arr3 = {30, 25, 5, 10};
//        Arrays.stream(arr3).limit(2).forEach(str -> System.out.print(str + " "));
//        System.out.println();
//
//        // Base operations: intermediate operations - skip()
//        Stream.of(arr3).skip(2).forEach(System.out::print);
//        System.out.println();
//
//        // Base operations: intermediate operations - sorted()
//        Arrays.stream(arr3).sorted().forEach(str -> System.out.print(str + " "));
//
//        // Processing order
//        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4").filter(s -> {
//            System.out.println("Фильтр" + s);
//            return true;
//        });
//
//        Stream.of("1", "2", "3", "4", "5").filter(s -> {
//            System.out.println("\n Фильтр: " + s);
//            return true;
//        }).forEach(s -> System.out.println("Результат: " + s));
//
//        System.out.println("\n not effective order of execution");
//
//        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4").map(s -> {
//            System.out.println("map: " + s);
//            return s.toUpperCase();
//        }).filter(s -> {
//            System.out.println("filter: " + s);
//            return s.startsWith("A");
//        }).forEach(s -> System.out.println("forEach: " + s));
//
//        System.out.println("\neffective order of execution: swap \"map\" and \"filter\" operations");
//
//        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4").filter(s -> {
//            System.out.println("filter: " + s);
//            return s.startsWith("a");
//        }).map(s -> {
//            System.out.println("map: " + s);
//            return s.toUpperCase();
//        }).forEach(s -> System.out.println("forEach: " + s));

        // Parallel streams: stream count
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());

//        -Djava.util.concurrent.ForkJoinPool.commmon.parallelism = 3 // don't work

        // Parallel streams: current thread/stream info
//        System.out.println("\ncurrent thread/stream info");
//        Arrays.asList("a1", "a2", "b1", "c2", "c1")
//                .parallelStream()
//                .filter(s -> {
//                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
//                    return true;
//                })
//                .map(s -> {
//                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.printf("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
//
//        System.out.println("\ncurrent thread/stream info\n");
//
//        Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream()
//                .filter(s -> {
//                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
//                    return true;
//                })
//                .map(s -> {
//                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
//                    return s.toUpperCase();
//                })
//                .sorted((s1, s2) -> {
//                    System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
//                    return s1.compareTo(s2);
//                })
//                .forEach(s ->
//                        System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

    }
}
