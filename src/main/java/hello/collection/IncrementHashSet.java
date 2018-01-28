package hello.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by pandeyu on 18/1/28.
 */
public class IncrementHashSet extends HashSet {

    private  int addCount;

    @Override
    public boolean add(Object o) {
        addCount++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }


    public static void main(String[] args){
        IncrementHashSet i = new IncrementHashSet();
        i.addAll(Arrays.asList(new String[]{"a","b","c"}));
        System.out.println(i.getAddCount());
    }
}
