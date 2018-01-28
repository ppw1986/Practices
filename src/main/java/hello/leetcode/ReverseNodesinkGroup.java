package hello.leetcode;

/**
 * Created by pandeyu on 17/11/28.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode p = head;
        ListNode q = null;
        ListNode[] list = new ListNode[k];
        boolean isNull = false;

        while (p!=null){
            for(int i=0;i<k; ++i) {

                list[i] = p;
                if(p==null){
                    continue;
                }else if(p.next==null){
                    p = p.next;
                }else{
                    q = p.next.next;
                    p = p.next;
                    p.next = q;
//                    p = p.next;
//                    p.next =  p.next.next;
                }
            }

            int i = 0;
            int j = k-1;
            if(list[j]!=null){
                for(;i<j;i++,j--){
                    int tmp = list[i].val;
                    list[i].val = list[j].val;
                    list[j].val = tmp;
                }
            }

        }

        return head;
    }

    private void setList(ListNode head, ListNode[] list, int k) {
        ListNode p  = head;
        for(int i = 0 ; i<k; i++) {
            list[i] = p;
            if (p == null) {
                continue;
            } else if (p.next == null) {
                p = p.next;
            } else {
                p.next = p.next.next;
                p = p.next;
                p.setNext(p.getNext().getNext());
                p.setNext(p.getNext());
            }
        }
    }

    public static  void main(String[] args){
        ListNode n = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n.next = n2;
        ReverseNodesinkGroup r = new ReverseNodesinkGroup();
        r.reverseKGroup(n,1);
    }
}
