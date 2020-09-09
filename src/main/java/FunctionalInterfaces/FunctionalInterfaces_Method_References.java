package FunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FunctionalInterfaces_Method_References {

    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {

        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");

        courses.stream()
                .map(String::toUpperCase)
                .forEach(FunctionalInterfaces_Method_References::print);
    }

    Supplier<String>supplier = String::new;
}
