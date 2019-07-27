/**
 * Complete me!
 **/
public class StringBinarySearchTree {

    private Node root;

    class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
        }

    } 

    public void put(String data) {
       root = putRec(root, data);
    }

    private Node putRec(Node node, String data) { 
           if(node == null)
                return new Node(data);
          int comp = data.compareTo(node.data);
          if(comp < 0)
              node.left = putRec(node.left, data);
          else if (comp > 0)
              node.right = putRec(node.right, data);
          else node.data = data;
          return node;
    } 

    public Object get(Comparable key) {
        return null;
    }

    public void printBst(String mode) {
        if(root != null) {
            if("in".equalsIgnoreCase(mode) || "".equals(mode))
                printBstRecInOrder(root);
            if("pre".equalsIgnoreCase(mode))
                printBstRecPreOrder(root);
            if("post".equalsIgnoreCase(mode))
                printBstRecPostOrder(root);
        }
        else System.out.println("The BST is empty");
    } 

    private void printBstRecInOrder(Node node) {
        if(node != null) {
            printBstRecInOrder(node.left);
            visit(node);
            printBstRecInOrder(node.right);
        }
    }
    
    private void printBstRecPreOrder(Node node) {
        if(node != null) {
            visit(node);
            printBstRecPreOrder(node.left);
            printBstRecPreOrder(node.right);
        }
    }

    private void printBstRecPostOrder(Node node) {
        if(node != null) {
            printBstRecPostOrder(node.left);
            printBstRecPostOrder(node.right);
            visit(node);
        }
    }

    private void visit(Node node) {
        System.out.printf(" %s ", node.data);
    }

    public static void main(String[] args) {
       StringBinarySearchTree bst = new StringBinarySearchTree();
       
       bst.put("A");
       bst.put("E");
       bst.put("F");
       bst.put("D");
       bst.put("C");
       bst.put("H");
       bst.put("B");
       bst.put("G");
       bst.put("G");

       String mode = "";
        if(args.length > 0)
            mode = args[0];
        bst.printBst(mode);
    }

} 
