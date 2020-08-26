package FunctionalInterfaceExample7;

@FunctionalInterface
interface StringConcat{
    public String sconcat(String a, String b);

}

public class MyFunctionalInterfaceExample7 {

    public static void main(String[] args) {
        //lambda expressions with multiple parameters
    StringConcat stringConcat= (str1, str2)->(str1+str2);
        System.out.println(stringConcat);
    }

}
