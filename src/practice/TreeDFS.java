package practice;

class NodeDFS{
    int data;
    NodeDFS left;
    NodeDFS right;

    NodeDFS(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeDFS {

    NodeDFS root;

    void printDFS(){
        if (root == null){
            System.out.println("Tree us empty");
            return;
        }
        performDFS(root);
    }

    void performDFS(NodeDFS node){
        if (node != null){
            System.out.println("Data is : "+node.data);
            performDFS(node.left);
            performDFS(node.right);
        }
    }

    public static void main(String[] args) {
        TreeDFS tree = new TreeDFS();
        tree.root = new NodeDFS(1);
        tree.root.left = new NodeDFS(2);
        tree.root.right = new NodeDFS(3);
        tree.root.left.left = new NodeDFS(4);
        tree.root.left.right = new NodeDFS(5);

        tree.printDFS();
    }

}
