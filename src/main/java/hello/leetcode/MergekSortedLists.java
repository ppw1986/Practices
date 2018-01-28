package hello.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pandeyu on 17/11/26.
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode l,root;
        l=root= null;

        boolean notEmpty = true;
        do{
            int index = 0;
            Integer min = null;
            for(int i =0 ; i<lists.length;i++){
                ListNode n = lists[i];
                if(min==null){
                    if(n!=null){
                        min = n.val;
                        index = i;
                    }
                }

                if(min!=null && n!=null){
                    if(min>n.val){

                        min = n.val;
                        index = i;
                    }
                }
            }

            if(l==null&&min!=null){
                ListNode n = new ListNode(lists[index].val);
                root = n;
                l = root;
                lists[index] = lists[index].next;
                notEmpty = true;
            }else if(min!=null){
                ListNode n = new ListNode(lists[index].val);
//                n.next = l.next;
                l.next = n;
                l = l.next;
                lists[index] = lists[index].next;
                notEmpty =  true;
            }else {
                notEmpty = false;
            }
            min = null;
        }while (notEmpty);


        return root;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(100,new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }
        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;
            if(n.next!=null)
                queue.offer(n.next);
        }
        return head.next;
    }


    public static  void main(String[] args){
//        ListNode n1 = new ListNode(0);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;

//        ListNode n4 = new ListNode(1);
//        ListNode n5 = new ListNode(0);
//
//        MergekSortedLists m = new MergekSortedLists();
//        ListNode l = m.mergeKLists(new ListNode[]{n4,n5});

        PriorityQueue<Integer> q = new PriorityQueue();
        q.offer(2);
        q.offer(7);
        q.offer(1);

        while (!q.isEmpty())
            System.out.print(q.poll());

    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}