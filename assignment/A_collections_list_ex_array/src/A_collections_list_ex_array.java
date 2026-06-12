import java.util.Arrays;

public class A_collections_list_ex_array {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        // --- Step 2~4 확인 ---
        list.addLast("가");
        list.addLast("나");
        list.addLast("다");
        System.out.println("size = " + list.size());                 // 기대: 3
        System.out.println("0,1,2 = " + list.get(0) + ", "
                + list.get(1) + ", "
                + list.get(2));                                       // 기대: 가, 나, 다

        // --- Step 6 확인 ---
        list.addFirst("앞");
        System.out.println("addFirst 후 0,1 = " + list.get(0) + ", " + list.get(1)); // 기대: 앞, 가
        System.out.println("size = " + list.size());                 // 기대: 4

        // --- 도전 확인 ---
        list.insert(2, "중간");
        System.out.println("insert(2) 후: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2)); // 앞, 가, 중간
        list.remove(2);
        System.out.println("remove(2) 후: " + list.get(0) + ", " + list.get(1) + ", " + list.get(2)); // 앞, 가, 나
    }
}


class MyArrayList {

    // [Step 1] 필드: 데이터를 담을 배열과 현재 개수
    private String[] arr = new String[10];
    private int size = 0;

    // [Step 2] 맨 뒤에 추가
    void addLast(String data) {
        ensureCapacity();          // 공간 확보
        arr[size] = data;          // 빈 끝자리(size 위치)에 저장
        size++;                    // 개수 증가
    }

    // [Step 3] 인덱스로 꺼내기
    String get(int index) {
        return arr[index];         // index 위치의 값 반환
    }

    // [Step 4] 현재 개수
    int size() {
        return size;               // size 필드 반환
    }

    // [Step 5] 공간이 꽉 찼으면 배열을 2배로 늘리기
    private void ensureCapacity() {
        if (size == arr.length) {                          // 꽉 찼으면
            arr = Arrays.copyOf(arr, arr.length * 2);     // 2배 크기로 복사
        }
    }

    // [Step 6] 맨 앞에 추가
    void addFirst(String data) {
        ensureCapacity();                    // 1) 공간 확보
        for (int i = size; i >= 1; i--) {   // 2) 맨 뒤부터 한 칸씩 뒤로 밀기
            arr[i] = arr[i - 1];
        }
        arr[0] = data;                       // 3) 0번 자리에 data 삽입
        size++;
    }

    // [도전] index 위치에 삽입
    void insert(int index, String data) {
        ensureCapacity();
        for (int i = size; i >= index + 1; i--) {  // index 뒤 요소를 한 칸씩 뒤로
            arr[i] = arr[i - 1];
        }
        arr[index] = data;
        size++;
    }

    // [도전] index 위치 삭제
    void remove(int index) {
        for (int i = index; i < size - 1; i++) {   // index 뒤 요소를 한 칸씩 앞으로
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;   // 마지막 빈 자리 정리
        size--;
    }
}