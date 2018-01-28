package hello;

/**
 * Created by pandeyu on 18/1/27.
 */
public class CloneI {

    public static void main(String[] arg) throws CloneNotSupportedException {

        C2 c2  =new CloneI().new C2(1,2);
        try{
            System.out.println(c2.clone());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(c2.clone().equals(c2));
        System.out.println(c2.clone() == c2);

        C3 c3 = new CloneI().new C3(1,2,3);
        System.out.println(c3.clone().getClass()==c3.getClass());

//        C1 c1 = new CloneI().new C1(1,2);
//        try{
//            System.out.println(c1.clone());
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        //shallow copy
        //deep copy
    }

    class C1{
        private int a;
        private int b;

        public C1(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class C2 implements Cloneable{
        private int a;
        private int b;

        public C2(int a, int b) {
            this.a = a;
            this.b = b;
            System.out.println("this is C2 constructor");
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class C3 extends C2{
        private int c;

        public C3(int a, int b, int c) {
            super(a, b);
            this.c = c;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }
}
