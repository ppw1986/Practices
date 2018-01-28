package hello.serialable.B;

import java.io.Serializable;

/**
 * Created by pandeyu on 18/1/2.
 */
public class Serial implements Serializable {
    /**   *   */
    private static final long serialVersionUID = 6977402643848374753L;
    int id;
    String name;

    public Serial(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "DATA: " + id + " " + name;
    }
}

