package hello.language;

/**
 * Created by pandeyu on 17/12/4.
 */
public class InnerClass {

    private  InnerClass(){}

    private int outInt;
    private static int outStaticInt;

    class Inner{

        public int innerInt;
        public int innerInt2;

        public Inner(){
            innerInt = outInt;
            innerInt2 = outStaticInt;
        }
    }

    public void setOutInt(int outInt) {
        this.outInt = outInt;
    }

    public static void setOutStaticInt(int outStaticInt) {
        InnerClass.outStaticInt = outStaticInt;
    }

    public static void main(String[] args){
        InnerClass i = new InnerClass();
        i.setOutInt(1);
        InnerClass.setOutStaticInt(2);

        Inner inner = i.new Inner();
        System.out.println(inner.innerInt);
        System.out.println(inner.innerInt2);
    }
}
