package hello.grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Generic <br/>
 * Description:	 ADD Description. <br/>
 * Date:     18/1/30 <br/>
 *
 * @author ppw1986 <br/>
 * @version <br/>
 * @see <br/>
 */
public class Generic {

    public static void main(String[] args){

//        unsafa();

        diffjdk();
    }

    private static void unsafa(){
        List<String> stings = new ArrayList<String>();
        unsafeAdd(stings,new Integer(42));
        String s = stings.get(0);
    }

    private static void unsafeAdd(List list, Integer integer) {
        list.add(integer);
    }

    private static void diffjdk() {
        List<String> list = new ArrayList<String>();
        System.out.println(method(list));
    }

    //jdk6 jdk7
    public static int method(List<String> list){
        return 0;
    }

    public static String method(List<Integer> list){
        return "";
    }

}
