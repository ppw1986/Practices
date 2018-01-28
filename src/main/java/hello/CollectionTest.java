package hello;

/**
 * Created by pandeyu on 17/11/6.
 */
public class CollectionTest {

    public static void main(String[] args){
        int a =1000000;
        System.out.println(hash(a));
    }

    static int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
