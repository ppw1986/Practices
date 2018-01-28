package hello.grammar;

/**
 * Created by pandeyu on 18/1/7.
 */
public class Keyword {

    public static void main(String[] args){
        //类名可以用作标识符
        String String = "String";
        Object Object = null;
        Integer Integer = new Integer(1);
    //让代码难以理解怎么样？
        Float Double = 1.0f;
        Double Float = 2.0d;
        if (String instanceof String) {
            if (Float instanceof Double) {
                if (Double instanceof Float) {
                    System.out.print("Can anyone read this code???");
                }
            }
        }
    }
}
