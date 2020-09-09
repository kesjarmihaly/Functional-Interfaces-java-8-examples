package FunctionalProgramming_Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printCubesOfOddNumbersInListFunctional(numbers);
        printOddNumbersInListFunctional(numbers);

        //Structured megoldasok, de ugyanazok
        printAllNumbersInListStructured(numbers);
        printEvenNumbersInListStructured(numbers);


        List<Integer> squaredNumbers = squareList(numbers);

        List<Integer> evenNumbersOnly = numbers.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.toList());


        System.out.println(squaredNumbers);
        System.out.println(evenNumbersOnly);

         int sum = addListFunctional(numbers);
         System.out.println(sum);

        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        courses.stream()
                .forEach(System.out::println);

        courses.stream()
                .filter(c ->c.contains("Spring"))
                .forEach(System.out::println);

        courses.stream()
                .filter(c->c.length()>=4)
                .forEach(System.out::println);

        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);


        List<Integer> numbers1 = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .distinct() //Stream<T> Intermediate
                .sorted() //Stream<T>
                .forEach(System.out::println); //void

        List<Integer> squaredNumbers1 = numbers1.stream()
                .map(number -> number * number) //Stream<R>
                .collect(Collectors.toList()); //R

        List<Integer> evenNumbersOnly1 = numbers1.stream()
                .filter(x -> x % 2 == 0) //Stream<T>
                .collect(Collectors.toList());

        int sum1 = numbers1.stream()
                .reduce(0, (x,y) -> x*x + y*y); //T

        int greatest = numbers1.stream()
                .reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x:y);

        List<String> courses1 = Arrays.asList("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        List<String> coursesSortedByLengthOfCourseTitle = courses.stream()
                .sorted(Comparator.comparing(str -> str.length()))
                .collect(Collectors.toList());


    }

    private static List<Integer> squareList(List<Integer> numbers) {
        //1 , 5, 6
        //1 -> 1
        //5 -> 25
        //6 -> 36

        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        //Stream of number -> One result value
        //Combine them into one result => One Value
        // 0 and FP02Functional::sum
        return numbers.stream()
                .parallel()
                //.reduce(0, FP02Functional::sum);
                // .reduce(0, (x,y) -> x + y);
                .reduce(0, Integer::sum);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        for (int number : numbers) {
            System.out.println(number);
        }

    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }

    }

    private static void printOddNumbersInListFunctional (List<Integer> numbers){
        numbers.stream() //convert to Stream
                .filter(number -> number % 2 != 0) //Lambda expression
                .forEach(System.out::println); //Method reference
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers){

        numbers.stream() //Convert to String
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }
}
