package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left = null;
        this.right = null;
    }
}

public class TreeBFS {

    Node root;

    void pintBFS(){
        if (this.root == null){
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.data+"");

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.pintBFS();
    }

}
