package hello.language;

import java.lang.reflect.Constructor;

/**
 * Created by pandeyu on 17/12/4.
 */
public class Reflection {

    private Reflection(){}

    public static void main(String[] args) throws NoSuchMethodException {

        Class<InnerClass> c = InnerClass.class;
        Constructor[] cons = c.getConstructors();
        for(Constructor constructor : cons){
            System.out.println("getConstructors");
            System.out.println(constructor);
        }


        cons = c.getDeclaredConstructors();
        for(Constructor constructor : cons){
            System.out.println("getDeclaredConstructors");
            System.out.println(constructor);
        }

        Constructor con;
//        con = c.getConstructor();
//        System.out.println("getConstructor");
//        System.out.println(con);

        con = c.getDeclaredConstructor();
        System.out.println("getDeclaredConstructor");
        System.out.println(con);
    }


    class inner{

        private int i = 1;
        private inner(){
            i = 2;
        }
    }
}
