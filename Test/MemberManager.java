public class MemberManager {
    private Member[] members;   // 인터페이스 타입 배열
    private int memberCnt;

    public MemberManager(int capacity) {
        members = new Member[capacity];
        memberCnt = 0;
    }

    // ───── 상태 확인 ─────
    public boolean isFull()  { return memberCnt == members.length; }
    public int getCount()    { return memberCnt; }
    public int getCapacity() { return members.length; }

    public boolean existsEmail(String email) {
        for (int i = 0; i < memberCnt; i++)
            if (members[i].getEmail().equals(email)) return true;
        return false;
    }

    // ───── 추가 ─────
    public void add(Member m) {
        members[memberCnt] = m;
        memberCnt++;
    }

    // ───── 조회 ─────
    public Member findByEmail(String email) {
        for (int i = 0; i < memberCnt; i++)
            if (members[i].getEmail().equals(email)) return members[i];
        return null;
    }

    public Member findByName(String name) {
        for (int i = 0; i < memberCnt; i++)
            if (members[i].getName().equals(name)) return members[i];
        return null;
    }

    public void printAll() {
        if (memberCnt == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        for (int i = 0; i < memberCnt; i++)
            members[i].printInfo();   // default 메서드 호출 (다형성)
    }

    // ───── 수정 ─────
    public boolean update(String email, String name, String newEmail, String phone) {
        Member m = findByEmail(email);
        if (m == null) return false;
        m.update(name, newEmail, phone);
        return true;
    }

    // ───── 삭제 ─────
    public boolean delete(String email) {
        int idx = -1;
        for (int i = 0; i < memberCnt; i++)
            if (members[i].getEmail().equals(email)) { idx = i; break; }
        if (idx == -1) return false;

        for (int i = idx; i < memberCnt - 1; i++)
            members[i] = members[i + 1];   // 한 칸씩 당기기
        members[memberCnt - 1] = null;
        memberCnt--;
        return true;
    }
}
