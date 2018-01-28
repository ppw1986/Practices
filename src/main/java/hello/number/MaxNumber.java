package hello.number;

/**
 * Created by pandeyu on 18/1/27.
 */
public class MaxNumber {

    public static void main(String[] args){


        limitValue();

        overflow();
    }

    private static void limitValue() {
        System.out.println("integer max value : "+Integer.MAX_VALUE);
        System.out.println("integer min value : "+Integer.MIN_VALUE);
        System.out.println("double max value : "+Double.MAX_VALUE);
        System.out.println("double min value : "+Double.MIN_VALUE);
        System.out.println("float max value : "+Float.MAX_VALUE);
        System.out.println("float min value : "+Float.MIN_VALUE);
    }

    private static void overflow() {
        int i  = Integer.MAX_VALUE-1;
        int j = Integer.MIN_VALUE+1;
        int k = i-j;
        System.out.println(""+i+" - "+ j +" = " +k);
    }
}
