package HashMap;
public class MyHashMap {

    private Node[] buckets;
    private int capacity=16; //버킷의 용량
    private int size=0; //버킷의 개수

    static class Node{
        String key;
        Integer value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public MyHashMap() {
        buckets = new Node[capacity];
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, Integer value) {
        int idx = getIndex(key);
        Node head = buckets[idx];

        // 같은 키가 이미 있나? → 값만 갱신
        for (Node n = head; n != null; n = n.next) {
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        // 없으면 새 노드를 맨 앞에 추가 (체이닝)
        Node node = new Node(key, value);
        node.next = head;
        buckets[idx] = node;
        size++;
    }
    public Integer get(String key) {
        int idx = getIndex(key);
        for (Node n = buckets[idx]; n != null; n = n.next) {
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;   // 끝까지 못 찾으면 null
    }
    public int size() {
        return size;
    }

    public boolean containsKey(String key) {
        int idx = getIndex(key);
        for (Node n = buckets[idx]; n != null; n = n.next) {
            if (n.key.equals(key)) return true;
        }
        return false;
    }

    public Integer remove(String key) {
        int idx = getIndex(key);
        Node n = buckets[idx];
        Node prev = null;

        while (n != null) {
            if (n.key.equals(key)) {
                if (prev == null) buckets[idx] = n.next;  // 첫 노드 삭제
                else              prev.next = n.next;     // 중간/끝 노드 삭제
                size--;
                return n.value;
            }
            prev = n;
            n = n.next;
        }
        return null;
    }


}