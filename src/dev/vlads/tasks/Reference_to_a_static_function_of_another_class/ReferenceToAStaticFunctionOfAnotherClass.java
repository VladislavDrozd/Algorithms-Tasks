package dev.vlads.tasks.Reference_to_a_static_function_of_another_class;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class ReferenceToAStaticFunctionOfAnotherClass {
    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<String> evenNumberList = numberList.stream()
                // 1) Lambda expression
                .filter((x) -> x % 2 == 0)
                // 2) reference to static function
                .map(MyConverter::convertIntegerToString)
                .collect(Collectors.toList());


        Printer printer = new Printer();
        // 3) reference to object function
        evenNumberList.forEach(printer::print);

        Print anonymousPrint = new Print() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };

        // 4) reference to anonymous object
        evenNumberList.forEach(anonymousPrint::print);

        // 5)


    }
}

class MyMath {

}

class MyConverter {
    public static String convertIntegerToString(Integer integer) {
        return Integer.toString(integer);
    }
}
interface Print {
    void print(String s);
}
class Printer implements Print {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}