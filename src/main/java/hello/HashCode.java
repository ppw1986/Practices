package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pandeyu on 18/1/27.
 */
public class HashCode {


    public static void main(String[] args){
        Phone p1 = new HashCode().new Phone(1,2,3);
        Phone p2 = new HashCode().new Phone(1,2,3);
        System.out.println("no overwrite equals and hashcode, equals : "+p1.equals(p2));
        System.out.println("no overwrite equals and hashcode, 1 hashcode : "+p1.hashCode());
        System.out.println("no overwrite equals and hashcode, 2 hashcode : "+p2.hashCode());

        List<Phone> l1 = new ArrayList<>();
        l1.add(p1);
        System.out.println("no overwrite equals and hashcode, list contains : "+l1.contains(p2));

        Map<Phone,String> m1 = new HashMap<>();
        m1.put(p1,"hello");
        System.out.println("no overwrite equals and hashcode, map get : "+m1.get(p2));


        PhoneEquals pe1  =new HashCode().new PhoneEquals(1,2,3);
        PhoneEquals pe2 =new HashCode().new PhoneEquals(1,2,3);
        System.out.println("only overwrite equals, equals : "+pe1.equals(pe2));
        System.out.println("only overwrite equals, 1 hashcode : "+pe1.hashCode());
        System.out.println("only overwrite equals, 2 hashcode : "+pe2.hashCode());

        List<PhoneEquals> l2 = new ArrayList<>();
        l2.add(pe1);
        System.out.println("only overwrite equals, list contains : "+l2.contains(pe2));

        Map<PhoneEquals,String> m2 = new HashMap<>();
        m2.put(pe1,"hello");
        System.out.println("only overwrite equals, map get : "+m2.get(pe2));

        PhoneEqualsHashCode pec1  =new HashCode().new PhoneEqualsHashCode(1,2,3);
        PhoneEqualsHashCode pec2 =new HashCode().new PhoneEqualsHashCode(1,2,3);
        System.out.println("overwrite equals and hashcode, equals : "+pec1.equals(pec2));
        System.out.println("overwrite equals and hashcode, 1 hashcode : "+pec1.hashCode());
        System.out.println("overwrite equals and hashcode, 2 hashcode : "+pec2.hashCode());

        List<PhoneEqualsHashCode> l3 = new ArrayList<>();
        l3.add(pec1);
        System.out.println("overwrite equals and hashcode, list contains : "+l3.contains(pec2));

        Map<PhoneEqualsHashCode,String> m3 = new HashMap<>();
        m3.put(pec1,"hello");
        System.out.println("overwrite equals and hashcode, map get : "+m3.get(pec2));
    }

    class Phone{

        private final int areaCode;
        private final int exchange;
        private final int extension;

        public Phone(int areaCode, int exchange, int extension) {
            this.areaCode = areaCode;
            this.exchange = exchange;
            this.extension = extension;
        }
    }

    class PhoneEquals{
        private final int areaCode;
        private final int exchange;
        private final int extension;

        public PhoneEquals(int areaCode, int exchange, int extension) {
            this.areaCode = areaCode;
            this.exchange = exchange;
            this.extension = extension;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PhoneEquals that = (PhoneEquals) o;

            if (areaCode != that.areaCode) return false;
            if (exchange != that.exchange) return false;
            return extension == that.extension;

        }
    }

    class PhoneEqualsHashCode{
        private final int areaCode;
        private final int exchange;
        private final int extension;

        public PhoneEqualsHashCode(int areaCode, int exchange, int extension) {
            this.areaCode = areaCode;
            this.exchange = exchange;
            this.extension = extension;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PhoneEqualsHashCode that = (PhoneEqualsHashCode) o;

            if (areaCode != that.areaCode) return false;
            if (exchange != that.exchange) return false;
            return extension == that.extension;

        }

        @Override
        public int hashCode() {
            int result = areaCode;
            result = 31 * result + exchange;
            result = 31 * result + extension;
            return result;
        }
    }
}
