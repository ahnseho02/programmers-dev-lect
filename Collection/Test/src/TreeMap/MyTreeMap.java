package TreeMap;
public class MyTreeMap {

    public class Node{
        String key;
        Integer value;
        Node left;
        Node right;
        Node(String key, Integer value){
            this.key=key;
            this.value=value;
        }
    }

    private Node root;
    private int size=0;

    public void put(String key, Integer value) {
        root = putNode(root, key, value);
    }

    private Node putNode(Node node, String key, Integer value) {
        if (node == null) {                 // 빈 자리 → 새 노드
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)      node.left  = putNode(node.left, key, value);   // 작으면 왼쪽
        else if (cmp > 0) node.right = putNode(node.right, key, value);  // 크면 오른쪽
        else              node.value = value;                           // 같으면 값 갱신
        return node;
    }

    public void printSorted() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);                                         // 1) 왼쪽 먼저
        System.out.print("[" + node.key + "=" + node.value + "] "); // 2) 자신
        inOrder(node.right);                                        // 3) 오른쪽
    }
}