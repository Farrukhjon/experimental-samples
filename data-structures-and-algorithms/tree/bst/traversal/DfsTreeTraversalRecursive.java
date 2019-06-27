public class DfsTreeTraversalRecursive {
 
    static class Node {
        String data;
        Node left;
        Node right;

        public Node (String data) {
            this.data = data;
        }
    }
    
    public void preOrderTraverse(Node node){
        if(node != null) {
            visit(node);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void inOrderTraverse(Node node){
        if(node != null) {
            inOrderTraverse(node.left);
            visit(node);
            inOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node node){
        if(node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            visit(node);
        }
    }

    private void visit(Node node) {
        if(node != null)
            System.out.printf(" %s ", node.data);
    }

    public static void main(String args[]) {
   
      DfsTreeTraversalRecursive dfs = new DfsTreeTraversalRecursive();

      Node root = new Node("A");
      
      root.left = new Node("B");
      root.right = new Node("C");
      
      root.left.left = new Node("D");
      root.left.right = new Node("E");

      root.right.left = new Node("F");
      root.right.right = new Node("G");

      String p = "";
      if(args.length > 0)
          p = args[0];
      
      if("pre".equalsIgnoreCase(p) || "".equals(p))
         dfs.preOrderTraverse(root);
      if("in".equalsIgnoreCase(p))
         dfs.inOrderTraverse(root);
      if("post".equalsIgnoreCase(p))
         dfs.postOrderTraverse(root);
    }

}


