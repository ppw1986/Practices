package hello.grammar;

/**
 * Created by pandeyu on 18/1/7.
 */
public class SealBox {

    public static void main(String[] args){

        Short s1 = 1;
        Short s2 = s1;
        s1++;
//        s1 = 2;
        System.out.println(s1);
        System.out.println(s2);


        Short2  s3 = new Short2();
        Short2 s4 = s3;
        s4.s = 2;

        System.out.println(s3.s);
        System.out.println(s4.s);

    }


}

class  Short2{
    short s =1;

}
