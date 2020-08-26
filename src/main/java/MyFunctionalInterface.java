@FunctionalInterface
interface MyFuncInterface {

    public int addMethod(int a, int b);
}
public class MyFunctionalInterface{

    public static void main(String args[]) {
        // lambda expression
        MyFuncInterface sum = (a, b) -> a + b;
        System.out.println("Result: "+sum.addMethod(12, 100));
    }
}