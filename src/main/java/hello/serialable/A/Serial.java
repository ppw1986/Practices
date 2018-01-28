package hello.serialable.A;

import java.io.Serializable;

/**
 * Created by pandeyu on 18/1/2.
 */
public class Serial implements Serializable {
    /**   *   */
    private static final long serialVersionUID = 6977402643848374753L;
    int id;
//    String name;
//    String id2;
//
//    public String getId2() {
//        return id2;
//    }
//
//    public void setId2(String id2) {
//        this.id2 = id2;
//    }

//    public Serial(int id, String name, String id2) {
//        this.id = id;
//        this.name = name;
//        this.id2 = id2;
//    }


    public Serial(int id) {
        this.id = id;
    }

//    public String toString() {
//        return "DATA: " + id + " " + name + "" + id2;
//    }
    public String toString() {
        return "DATA: " + id ;
    }
}

