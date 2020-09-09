package FunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalIntefaces_Example_2 {
    public static void main(String[] args) {

        List<Integer>numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer>isEvenPredicate= x->x%2==0;

        Function<Integer, Integer>squareFunction = x-> x*x;

        Function<Integer, String>stringOutputFunction = x->x + " ";

        Consumer<Integer>sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer>sumBinaryOperator=(x, y) -> x + y;

        //No input > return something
        Supplier<Integer>randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };

        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer>unaryOperator = x -> x * 3;
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String>biPredicate = (integer, str) ->{
            return integer<10 && str.length()>5;
        };
        System.out.println(biPredicate.test(10,"valami ami nagyobb mint 5"));


        BiFunction<Integer, String, String> biFunction = (integer,str) -> {
            return integer + " " + str;
        };
        System.out.println(biFunction.apply(15,"in 28 Minutes"));

        BiConsumer<Integer,String>biConsumer = (s1,s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(25,"in 25 Minutes");

        BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;

        IntBinaryOperator intBinaryOperator = (x,y) -> x + y;

        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator

        //Long, Double, Int


        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);

        int sum = numbers.stream()
                .reduce(0, sumBinaryOperator);








    }
}
