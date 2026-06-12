public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // --- Step 3 + 4 확인 ---
        list.addLast("가");
        list.addLast("나");
        list.addLast("다");
        System.out.print("addLast 후: ");
        list.printLinks();
        // 기대: [null <- 가 -> 나] [가 <- 나 -> 다] [나 <- 다 -> null]

        // --- Step 5 확인 ---
        list.addFirst("앞");
        System.out.print("addFirst 후: ");
        list.printLinks();
        // 기대: [null <- 앞 -> 가] [앞 <- 가 -> 나] [가 <- 나 -> 다] [나 <- 다 -> null]

        // --- Step 6 확인 ---
        System.out.println("get(2) = " + list.get(2));   // 기대: 나

        // --- Step 7 확인 ---
        list.insert(2, "끼움");
        System.out.print("insert 후: ");
        list.printLinks();
        // 기대: [null <- 앞 -> 가] [앞 <- 가 -> 끼움] [가 <- 끼움 -> 나] [끼움 <- 나 -> 다] [나 <- 다 -> null]

        // --- 도전 확인 ---
        list.remove(2);   // "끼움" 삭제
        System.out.print("remove(2) 후: ");
        list.printLinks();
        // 기대: [null <- 앞 -> 가] [앞 <- 가 -> 나] [가 <- 나 -> 다] [나 <- 다 -> null]
    }
}


class MyLinkedList {

    // [Step 1] 노드 한 칸
    static class Node {
        String data;
        Node prev;
        Node next;
        Node(String data) {
            this.data = data;   // data 설정
        }
    }

    // [Step 2] 필드
    private Node head;
    private Node tail;
    private int size;

    // [Step 3] 맨 뒤에 추가
    void addLast(String data) {
        Node node = new Node(data);
        if (head == null) {         // 리스트가 비어있으면
            head = tail = node;     // head, tail 모두 새 노드
        } else {
            node.prev = tail;       // 새 노드의 앞 = 현재 tail
            tail.next = node;       // 현재 tail의 뒤 = 새 노드
            tail = node;            // tail을 새 노드로 갱신
        }
        size++;
    }

    // [Step 4] 연결 상태 출력 (제공됨)
    void printLinks() {
        Node cur = head;
        while (cur != null) {
            String p = (cur.prev == null) ? "null" : cur.prev.data;
            String n = (cur.next == null) ? "null" : cur.next.data;
            System.out.print("[" + p + " <- " + cur.data + " -> " + n + "] ");
            cur = cur.next;
        }
        System.out.println();
    }

    // [Step 5] 맨 앞에 추가
    void addFirst(String data) {
        Node node = new Node(data);
        if (head == null) {         // 리스트가 비어있으면
            head = tail = node;
        } else {
            node.next = head;       // 새 노드의 뒤 = 현재 head
            head.prev = node;       // 현재 head의 앞 = 새 노드
            head = node;            // head를 새 노드로 갱신
        }
        size++;
    }

    // [Step 6] index번째 노드 찾기
    private Node nodeAt(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {   // index번 next 이동
            cur = cur.next;
        }
        return cur;
    }

    String get(int index) {
        return nodeAt(index).data;
    }

    // [Step 7] index 위치에 삽입 ★핵심★
    void insert(int index, String data) {
        if (index == 0) {           // 맨 앞 삽입
            addFirst(data);
        } else if (index == size) { // 맨 뒤 삽입
            addLast(data);
        } else {
            Node next = nodeAt(index);   // 삽입 위치의 기존 노드
            Node prev = next.prev;       // 그 앞 노드
            Node node = new Node(data);

            // 새 노드 양옆 연결
            node.prev = prev;
            node.next = next;
            // 기존 노드들이 새 노드를 가리키도록 갱신
            prev.next = node;
            next.prev = node;

            size++;
        }
    }

    // [도전] index 위치 노드 삭제
    void remove(int index) {
        if (index == 0) {               // 맨 앞 삭제
            head = head.next;
            if (head == null) tail = null;  // 노드가 1개였던 경우
            else head.prev = null;
        } else if (index == size - 1) { // 맨 뒤 삭제
            tail = tail.prev;
            if (tail == null) head = null;
            else tail.next = null;
        } else {                        // 중간 삭제
            Node target = nodeAt(index);
            Node prev = target.prev;
            Node next = target.next;
            prev.next = next;           // 앞 노드 → 뒤 노드 연결
            next.prev = prev;           // 뒤 노드 → 앞 노드 연결
        }
        size--;
    }

    int size() { return size; }
}