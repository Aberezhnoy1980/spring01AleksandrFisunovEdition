package ru.home;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIMain {
    public static void main(String[] args) throws IOException {
        // Lambda construction
//        class StreamAPIMain$1 implements Runnable {
//            @Override
//            public void run() {
//            }
//        }
//        Runnable r2 = new StreamAPIMain$1();

//        Runnable r1 = () -> System.out.println(1);
//        Runnable r2 = () -> System.out.println(2);
//
//        r1.run();
//        r2.run();
//
//        MyInterface myInterface1 = (a, b) -> System.out.println(a * b);
//        MyInterface myInterface2 = (a, b) -> System.out.println(a + b);
//
//        myInterface1.doSomething(2, 3);
//        myInterface2.doSomething(2, 3);

//        new Thread(() -> {
//        }).start();

//        filterEx();
//        secondEx();
//        thirdEx();
//        matchEx();
//        countEx();
//        findAnyEx();
//        mappingEx();
//        System.out.println(returnOrThrow());
//        reduceEx();
//        intStreamEx();
//        parallelStreamEx();
//        simpleStringEx();
//        streamFromFilesEx();
//        flatMapEx();
//        System.out.println(countWordsInFile(Paths.get("Stream-API/src/main/java/ru/home/funcProg/flatMapEx.txt")));
//        printTheMostFrequentWordInTheFile(Path.of("Stream-API/src/main/java/ru/home/funcProg/flatMapEx.txt"));
//        myOwnFilterEx();
        listFileFromPath();
        funcInterEx();
        streamAPIEx();
        optionalEx();
    }

    public static void filterEx() {
        System.out.println("filterEx: build stream for even numbers w/o lambda usage. Sourced List: {1, 2, 3, 4, 5, 6, 7, 8}");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + " ");
            }
        });
        System.out.println("\nfilterEx: build stream for odd numbers less than certain num with lambda expression usage. Sourced list the same");
        Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}).filter(integer -> integer < 7 && integer % 2 != 0).forEach(integer -> System.out.print(integer + " "));
//                .forEach(System.out::print);
    }

    public static void secondEx() {
        System.out.println("\n\nsecondEx: build a new List, and then use the stream to convert it to a new List of even squared nums, limited by the first two elements. Source: {1, 2, 3, 4, 5, 6, 7, 8}");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> out = nums.stream().filter(integer -> integer % 2 == 0).map(integer -> integer * integer).limit(2).collect(Collectors.toList());

        System.out.println(nums);
        System.out.println(out);
    }

    public static void thirdEx() {
        System.out.println("\n\nthirdEx: build new data flow and then use the stream to find unique values. Sources {1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 8, 9, 9}");
        IntStream.of(1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 8, 9, 9).distinct().forEach(integer -> System.out.print(integer + " "));

        System.out.println("\noption with short record when use method reference expression");

        IntStream.rangeClosed(1, 9).distinct().mapToObj(integer -> integer + " ").forEach(System.out::print);

        System.out.println("\nsome examples for method reference expression");

        Stream.of("a", "aaa", "aa", "aaaa", "bb", "ccdc", "dkjvbjdshjs", " kdjkf", "asetcvt").filter(string -> string.contains("a")).map(String::toUpperCase).map(String::length).forEach(System.out::print);
    }

    public static void matchEx() {
        System.out.println("\n\nmatchEx: checking data for compliance with certain conditions");
        List<Integer> checkList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        boolean ok = true;
        for (Integer i : checkList) {
            if (!(i < 10)) {
                ok = false;
                break;
            }
        }

        System.out.println(checkList.stream().allMatch(i -> i < 10));
        System.out.println(checkList.stream().anyMatch(i -> i == 4));
        System.out.println(checkList.stream().noneMatch(i -> i == 2));
        System.out.println(checkList.stream().noneMatch(i -> i == 10));
    }

    public static void countEx() {
        System.out.println("\n\ncountEx: write to the map the results of grouping and counting using a stream");
        Map<Integer, Long> collect = Stream.of("a", "bb", "aa", "b", "c", "ee", "nnn", "x", "qq").collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(collect);
    }

    public static void findAnyEx() {
        System.out.println("\n\nfindAnyEx:");
        List<Integer> findList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        findList.stream().filter(integer -> integer > 3).findAny().ifPresent(System.out::print);

        Optional<Integer> opt = findList.stream().filter(integer -> integer > 1).findAny();

        if (opt.isPresent()) {
            System.out.println("\n" + opt.get());
        }
        opt.ifPresent(System.out::print);
    }

    public static void mappingEx() {
        System.out.println("\n\nmappingEx:");
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s -> s.length();
        Predicate<Integer> evenNumFilter = integer -> integer % 2 == 0;
        Function<Integer, Integer> cube = integer -> (int) Math.pow(integer, 3);
        Function<Integer, Integer> anotherCube = integer -> integer * integer * integer;

        Stream.of(1, 2, 3).map(integer -> Math.pow(integer, 3));
        Stream.of(1, 2, 3).map(anotherCube);

        List<String> strList = Arrays.asList("A", "BB", "C", "DDD", "EE", "FFFF");
        List<Integer> strLength = strList.stream().map(string -> string.length()).collect(Collectors.toList());
        List<Integer> strLengthRefToMeth = strList.stream().map(String::length).collect(Collectors.toList());
        List<Integer> strLengthFromExpr = strList.stream().map(strToLen).collect(Collectors.toList());

        System.out.println(strList);
        System.out.println(strLength);
        System.out.println(strLengthFromExpr);
        System.out.println(strLengthRefToMeth);

        strList.stream().map(strToLen).forEach(string -> System.out.print(string + " "));
        strList.stream().map(strToLen).forEach(System.out::print);
    }

    public static String returnOrThrow() {
        System.out.println("\n\nreturnOrThrow: if you can't get back argument, you throw an exception or whatever you think is necessary");
//        String str = new String("...."); // str = myService.getStringFromDB();
//        if (str == null) {
//            throw new RuntimeException();
//        }
//        return str;
//        return Optional.of("A").orElseThrow(() -> new RuntimeException());

        Optional<String> opt = Optional.of("Java");
        return opt.orElseThrow(() -> new RuntimeException());
//        return opt.orElse("Z");
//        return opt.orElseThrow(RuntimeException::new);
    }

    public static void reduceEx() {
        System.out.println("\n\nreduceEx: summator");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }

        int streamSum = IntStream.rangeClosed(1, 5).reduce(0, (a, b) -> a + b);
        int anotherStreamSum = IntStream.rangeClosed(1, 5).reduce(0, Integer::sum);
        System.out.println(sum + " " + streamSum + " " + anotherStreamSum);
    }

    public static void intStreamEx() {
        System.out.println("\nintStreamEx: options for create stream of integers");
        IntStream myIntStream = IntStream.of(1, 2, 3, 4, 5, 6);

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(list.stream().mapToInt(i -> i).sum() + " " + myIntStream.sum());

        IntStream.rangeClosed(2, 10).filter(i -> i % 2 == 0).mapToObj(i -> i + " ").forEach(System.out::print);


        Map<Integer, Long> StreamMap = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("\nMap collection not friendly with the IntStream?\n" + StreamMap);
    }

    private static void parallelStreamEx() {
        System.out.println("\n\nparallelStreamEx: check stream/thread info");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        list.parallelStream().filter(i -> {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            return true;
        }).collect(Collectors.toSet());
    }

    private static void simpleStringEx() {
        System.out.println("\n\nsimpleStringEx: find unique words in string\n" + Arrays.stream("A A CC B C AA A A B CC C".split("\\s")).distinct().count());
    }

    public static void streamFromFilesEx() {
        System.out.println("\n\nstreamFromFileEx: read from file with stream");
        String data = "streamFromFileEx: read from file with stream";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("Stream-API/src/main/java/ru/home/funcProg/streamFromFiles.txt");
            out.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.lines(Paths.get("Stream-API/src/main/java/ru/home/funcProg/streamFromFiles.txt")).map(String::length).forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void flatMapEx() throws IOException {
        String flatMapEx = "A B C H G A A\nC D E A U X C\nA B F D X D B\nA G F E Q Q Q";
        FileOutputStream out = new FileOutputStream("Stream-API/src/main/java/ru/home/funcProg/flatMapEx.txt");
        out.write(flatMapEx.getBytes());
        if (out != null) out.close();

        System.out.println("\n\nflatMapEx:");
        Files.lines(Paths.get("Stream-API/src/main/java/ru/home/funcProg/flatMapEx.txt")).map(line -> line.split("\\s")).distinct().forEach(arr -> System.out.print(Arrays.toString(arr)));
        System.out.println("\n-------------------------------");
        Files.lines(Paths.get("Stream-API/src/main/java/ru/home/funcProg/flatMapEx.txt")).map(line -> line.split("\\s")).map(Arrays::stream).distinct()
//                    .forEach(System.out::print);
                .forEach(streamArray -> System.out.print(streamArray.collect(Collectors.toList())));
        System.out.println("\n-------------------------------");
        System.out.println(Files.lines(Paths.get("Stream-API/src/main/java/ru/home/funcProg/flatMapEx.txt")).map(line -> line.split("\\s")).flatMap(Arrays::stream).distinct().collect(Collectors.joining(", ", "Unique words: ", ".")));
    }

    public static Map<String, Long> countWordsInFile(Path path) {
        System.out.println("\n\ncountWordsInFile:");
        try {
            Map<String, Long> out = Files.lines(path).map(line -> line.split("\\s")).flatMap(Arrays::stream).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            return out;
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file: " + path.getFileName().toString());
        }
    }

    public static void printTheMostFrequentWordInTheFile(Path path) {
        System.out.println("\n\nprintTheMostFrequentWordInTheFile:");
        try {
            Files.lines(path).map(line -> line.split("\\s")).flatMap(Arrays::stream).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream().sorted((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue()).limit(1).findFirst().ifPresent(w -> System.out.print("The most frequent word: " + w.getKey()));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file: " + path.getFileName().toString());
        }
    }

    public static void myOwnFilterEx() {
        System.out.println("\n\nmyOwnFilterEx: customize filters");
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(myOwnFilter(ints, i -> i % 2 == 0));
        System.out.println(myOwnFilter(ints, i -> i % 2 != 0));
    }

    public static <T> List<T> myOwnFilter(List<T> list, Predicate<T> predicate) {
        List<T> copy = new ArrayList<>(list);
        copy.removeIf(o -> !predicate.test(o));
//        while (iter.hasNext()) {
//            T o = iter.next();
//            if (!predicate.test(o)) {
//                iter.remove();
//            }
//        }
        return copy;
    }

    public static void listFileFromPath() throws IOException {
        List<String> filesList = Files.list(Paths.get(".")).filter(p -> !Files.isDirectory(p)).map(p -> p.getFileName().toString()).collect(Collectors.toList());
        System.out.println("\n\nlistFileFromPath:\n" + filesList);

        List<String> longFilesList = new ArrayList<>();
        for (File o : new File(".").listFiles()) {
            if (o.isFile()) {
                longFilesList.add(o.getName());
            }
        }
        System.out.println(longFilesList);
    }

    public static void funcInterEx() {
        System.out.println("\n\nfuncInterEx: tasks from Aleksey Plekhanov course");
        Consumer<String> consumer = str -> System.out.println(str.length());
        Producer<String> producer = () -> "test";
        Function<String, Integer> function = String::length;
        consumer.accept("some text");
        consumer.accept("another text");
        consumer.accept("different digital 123453498765493");

        System.out.println(function.apply("some text for a function interface"));

        System.out.println(producer.produce());

        Thread t = new Thread(() -> {
            System.out.println("echo 123 execute at: " + Thread.currentThread().getName());
            int a = 1;
            int b = 2;
            System.out.println("sum of a = 1 and b = 2 is: " + (a + b) + ". Execute at: " + Thread.currentThread().getName());
        });
        t.start();
    }

    public static void streamAPIEx() {
        System.out.println("\n\nstreamAPIEx: tasks from Aleksey Plekhanov course");
        List<String> list = new ArrayList<>(Arrays.asList("123", "123456", "123456789"));
        System.out.println(list.stream()
                .filter(str -> str.length() < 7)
                .filter(str -> str.startsWith("1"))
                .filter(str -> !str.contains("7"))
                .limit(2)
                .map(String::length)
                .collect(Collectors.toList()) + Thread.currentThread().getName());
    }

    public static void optionalEx() {
        System.out.println("\n\noptionalEx:");
//        String excTest = null;
//        if (excTest != null) {
//            System.out.println(excTest.length());
//        }
//        final Optional<String> optional = Optional.of(excTest);
//        optional.map(String::length).ifPresent(System.out::println);
//        if(optional.isPresent())
//        optional.get();

        Arrays.stream(new int[] {1, 2, 3, 4, 5}).filter(i -> i < 4).findAny().ifPresent(System.out::print);
        Arrays.stream(new int[] {1, 2, 3, 4, 5}).filter(i -> i < 1).findAny().ifPresent(System.out::print);
        System.out.println();
//        Arrays.stream(new int[] {1, 2, 3, 4, 5}).filter(i -> i < 1).findAny().get(); // error
//        Stream.of(1, 2, 3, 4, 5).filter(i -> false).findAny().get(); // work

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.stream().filter(i -> i < 1).findAny().get();
    }
}
