package hello.sort;

import java.util.LinkedList;

/**
 * Created by pandeyu on 17/11/21.
 */
public class BinaryTree2 {


    public void preOrder(Node2 root){

        Node2 p = root;
        LinkedList<Node2> stack = new LinkedList<Node2>();
        if(p!=null){
            stack.push(p);

            while (p!=null){
                p = stack.pop();
                visit(p);

                if(p.getRight()!=null){
                    stack.push(p.getRight());
                }

                if(p.getLeft()!=null){
                    stack.push(p.getLeft());
                }
            }
        }
    }

    public void preOrder2(Node2 root){
        LinkedList<Node2> stack = new LinkedList<Node2>();
        Node2 p = root;

//        while (p!=null){
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                visit(p);
                stack.push(p);
                p = p.getLeft();
            }

//            p/* = stack.pop();
//            if(p.getRight()!=null){
//                p = p.getRight();
//            }*/

            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.getRight();
            }
        }

    }

    public void inOrder(Node2 root){
        LinkedList<Node2> stack = new LinkedList<Node2>();
        Node2 p = root;
        while (p!=null){
            while (p!=null){
                if(p.getRight()!=null){
                    stack.push(p.getRight());
                }
                stack.push(p);
                p = p.getLeft();
            }

//            while (!stack.isEmpty() &&p.getRight()==null){
//                p = stack.pop();
//                visit(p);
//            }
//
//            if(!stack.isEmpty()){
//                p = stack.pop();
//            }

            p = stack.pop();
            while (!stack.isEmpty() && p.getRight()==null){
                visit(p);
                p = stack.pop();
            }
            visit(p);

            if(!stack.isEmpty())
                p = stack.pop();
            else
                p = null;
        }
    }


    public void inOrder2(Node2 root){
        LinkedList<Node2> stack = new LinkedList<Node2>();
        Node2 p  = root;

        while (p!=null || !stack.isEmpty()){

            while (p!=null){
                stack.push(p);
                p = p.getLeft();
            }

            if(!stack.isEmpty()){
                p = stack.pop();
                visit(p);
                p = p.getRight();
            }

        }

    }

    public static void postOrder(Node2 root){
        LinkedList<Node2> stack = new LinkedList<Node2>();
        Node2 p,pre;
        p = pre = root;

        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p = p.getLeft();
            }

            if(!stack.isEmpty()){
//                Node2 tmp = stack.peek().getRight();
//                p = stack.pop();
//                visit(p);
//                pre = p;
//                if(tmp!=null){
//                    p = tmp;
//                }
                Node2 tmp = stack.peek().getRight();
                if(tmp==null || tmp == pre){
                    p = stack.pop();
                    visit(p);
                    pre = p;
                    p = null;
                }else {
                    p = tmp;
                }
            }
        }

    }

    public static void postOrder2(Node2 root){
        LinkedList<Node2> stack = new LinkedList<Node2>();
        LinkedList<Node2> tmp = new LinkedList<Node2>();
        Node2 p = root;

        while (p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                tmp.push(p);
                p = p.getRight();
            }

//            while (stack.peek().getLeft()==null){
//                p = stack.pop();
//            }
//            p = stack.pop();
//            p = p.getLeft();
            if (!stack.isEmpty()){
                p = stack.pop();
                p = p.getLeft();
            }
        }
        while (!tmp.isEmpty()){
            p = tmp.pop();
            visit(p);
        }

    }



    /** 访问节点 */
    public static void visit(Node2 p) {
        System.out.print(p.getKey() + " ");
    }

    class Node2 {
        private char key;
        private Node2 left, right;

        public Node2(char key) {
            this(key, null, null);
        }

        public Node2(char key, Node2 left, Node2 right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public char getKey() {
            return key;
        }

        public void setKey(char key) {
            this.key = key;
        }

        public Node2 getLeft() {
            return left;
        }

        public void setLeft(Node2 left) {
            this.left = left;
        }

        public Node2 getRight() {
            return right;
        }

        public void setRight(Node2 right) {
            this.right = right;
        }
    }
}

