package FunctionalInterfaceExample5;

@FunctionalInterface
interface MyFunctionalInterface{

    //method with no parameter
    public String sayHello();
}


public class FunctionalInterfaceExample5 {
    public static void main(String[] args) {
        //lambda expression
        MyFunctionalInterface msg = () -> {
            return "Hello";
        };
        System.out.println(msg.sayHello());
    }
}
