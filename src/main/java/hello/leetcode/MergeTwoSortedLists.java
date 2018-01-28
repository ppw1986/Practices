package hello.leetcode;

/**
 * Created by pandeyu on 17/11/26.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null || l2==null){
            return l1==null?  l2: l1;
        }

        ListNode root = new ListNode(0);
        ListNode p = root;

        do{
            ListNode n;
            if(l1.val<l2.val){
                n = new ListNode(l1.val);
                p.next = n;
                p = p.next;

                l1 = l1.next;
            } else if(l1.val>l2.val){
                n = new ListNode(l2.val);
                p.next = n;
                p = p.next;

                l2 = l2.next;
            }else {
                n = new ListNode(l1.val);
                p.next = n;
                p = p.next;

                n = new ListNode(l2.val);
                p.next = n;
                p = p.next;

                l1 = l1.next;
                l2 = l2.next;
            }
        }while (l1!=null && l2!=null);

        if(l1!=null){
            p.next = l1;
        }

        if(l2!=null){
            p.next = l2;
        }

        return root.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}

