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

    public Integer get(String key) {
        Node n = root;
        while (n != null) {
            int cmp = key.compareTo(n.key);
            if (cmp < 0)      n = n.left;    // 작으면 왼쪽으로
            else if (cmp > 0) n = n.right;   // 크면 오른쪽으로
            else              return n.value; // 찾음!
        }
        return null;   // 끝까지 못 찾음
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

    public int size() { return size; }

    public boolean containsKey(String key) {
        Node n = root;
        while (n != null) {
            int cmp = key.compareTo(n.key);
            if (cmp < 0)      n = n.left;
            else if (cmp > 0) n = n.right;
            else              return true;
        }
        return false;
    }

    public String firstKey() {           // 가장 작은 키 = 맨 왼쪽
        if (root == null) return null;
        Node n = root;
        while (n.left != null) n = n.left;
        return n.key;
    }

    public String lastKey() {            // 가장 큰 키 = 맨 오른쪽
        if (root == null) return null;
        Node n = root;
        while (n.right != null) n = n.right;
        return n.key;
    }

    public Integer remove(String key) {
        Integer old = get(key);
        if (old == null) return null;   // 없으면 아무것도 안 함
        root = removeNode(root, key);
        size--;
        return old;
    }

    private Node removeNode(Node node, String key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)      node.left  = removeNode(node.left, key);
        else if (cmp > 0) node.right = removeNode(node.right, key);
        else {
            // 찾음! 경우를 나눈다
            if (node.left == null)  return node.right;  // 경우1·2 (왼쪽 없음)
            if (node.right == null) return node.left;   // 경우2 (오른쪽 없음)

            // 경우3: 자식 둘 → 오른쪽의 최소(후계자)로 대체
            Node succ = node.right;
            while (succ.left != null) succ = succ.left;
            node.key = succ.key;
            node.value = succ.value;
            node.right = removeNode(node.right, succ.key); // 후계자 제거
        }
        return node;
    }


}