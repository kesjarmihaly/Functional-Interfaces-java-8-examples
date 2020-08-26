package FunctionalInterfaceExample6;

@FunctionalInterface
interface MyFunctionalInterface{
    //a method with single parameter
    public int incrementByFive(int a);
}


public class MyFuncctionalInterfaceExample6 {

    public static void main(String[] args) {

        //lambda expression with single parameter num
        MyFunctionalInterface fun = (num)->num+5;
        System.out.println(fun.incrementByFive(22));
    }
}
