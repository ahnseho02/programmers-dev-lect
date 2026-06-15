package Tree;

public class MyTree {

    public class Node{
        private int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }
    private Node root;

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) return new Node(value);   // 빈 자리 → 새 노드
        if (value < node.value)      node.left  = insertNode(node.left, value);
        else if (value > node.value) node.right = insertNode(node.right, value);
        // 같은 값이면 무시(중복 안 넣음)
        return node;
    }

    public void preOrder() {
        System.out.print("전위: ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");   // 1) 루트 먼저
        preOrder(node.left);                   // 2) 왼쪽
        preOrder(node.right);                  // 3) 오른쪽
    }


    public void inOrder() {
        System.out.print("중위: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);                   // 1) 왼쪽
        System.out.print(node.value + " ");   // 2) 루트 (가운데!)
        inOrder(node.right);                  // 3) 오른쪽
    }

    public void postOrder() {
        System.out.print("후위: ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);                 // 1) 왼쪽
        postOrder(node.right);                // 2) 오른쪽
        System.out.print(node.value + " ");   // 3) 루트 (마지막!)
    }
}