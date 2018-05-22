import java.util.Arrays;

public class helloWorld {
    public static void main(String[] args){
        System.out.println("Hello Rand");

        String[] strings = new String[] { "foo", "bar" };
        Integer a=5;
        changeReference(strings, a);
        System.out.println(Arrays.toString(strings)+"  "+strings[0] ); // still [foo, bar]
        changeValue(strings);
        System.out.println(Arrays.toString(strings)); // [foo, foo]


    }
    public static void changeReference(String[] strings, Integer a) {
        strings = new String[] { "foo", "foo" };
        a.getClass();
    }
    public static void changeValue(String[] strings) {
        strings[1] = "foo";
    }
}
