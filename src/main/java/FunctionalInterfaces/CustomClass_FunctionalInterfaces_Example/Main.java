package FunctionalInterfaces.CustomClass_FunctionalInterfaces_Example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Course> courses = Arrays.asList(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore()>95;

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList())
        );

        Comparator<Course>comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();

        System.out.println(
                courses.stream()
                            .sorted(comparingByNoOfStudentsDecreasing)
                            .collect(Collectors.toList())
        );

        Comparator<Course>comparingNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudents)
                                                                        .thenComparingInt(Course::getReviewScore)
                                                                        .reversed();

        System.out.println(
                courses.stream()
                                .sorted(comparingNoOfStudentsAndNoOfReviews)
                                .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                                .sorted(comparingNoOfStudentsAndNoOfReviews)
                                .limit(5)
                                .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                                .sorted(comparingNoOfStudentsAndNoOfReviews)
                                .skip(3)
                                .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                                .sorted(comparingNoOfStudentsAndNoOfReviews)
                                .skip(3)
                                .limit(5)
                                .collect(Collectors.toList())
        );

        System.out.println(courses);


        System.out.println(
                courses.stream()
                        .max(comparingNoOfStudentsAndNoOfReviews)
        );

        System.out.println(
                courses.stream()
                        .min(comparingNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );

        System.out.println(
                courses.stream()
                                .min(comparingNoOfStudentsAndNoOfReviews)
                                .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );

        System.out.println(
                courses.stream()
                                .filter(reviewScoreLessThan90Predicate)
                                .findFirst()
        );


        System.out.println(
                courses.stream()
                                .filter(reviewScoreGreaterThan90Predicate)
                                .findFirst()
        );

        System.out.println(
                courses.stream()
                                .filter(reviewScoreGreaterThan95Predicate)
                                .findAny()
        );

        System.out.println(
                courses.stream()
                                .filter(reviewScoreGreaterThan95Predicate)
                                .mapToInt(Course::getNoOfStudents)
                                .sum()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        System.out.println(
                courses.stream()
                                .collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList()))));

        Predicate<Course> reviewScoreGreaterThan95Predicate2=createPredicateWithCutoffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2= createPredicateWithCutoffReviewScore(90);

    }

    private static Predicate<Course>createPredicateWithCutoffReviewScore(int cutoffReviewScore){
        return course -> course.getReviewScore() > cutoffReviewScore;
    };
}
