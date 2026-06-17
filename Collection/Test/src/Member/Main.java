package Member;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[1]Lite:10 [2]Basic:20 [3]Premium:30");
        PricePlan plan = null;
        while (plan == null) {
            plan = PricePlan.from(readInt(sc));
            if (plan == null) System.out.println("1~3 중에서 선택하세요.");
        }
        MemberManager manager = new MemberManager(plan.getCapacity());

        while (true) {
            System.out.println("\n[현재 " + manager.size() + "/" + manager.capacity() + "]");
            System.out.println("[1]추가 [2]메일조회 [3]이름조회 [4]전체 [5]수정 [6]삭제 [7]종료");
            int menu = readInt(sc);

            switch (menu) {
                case 1: {   // 추가
                    if (manager.isFull()) { System.out.println("정원이 찼습니다."); break; }
                    System.out.println("등급 [1]일반 [2]VIP");
                    int grade = readInt(sc);
                    System.out.print("이름 > ");   String name  = sc.nextLine();
                    System.out.print("이메일 > "); String email = sc.nextLine();
                    System.out.print("연락처 > "); String phone = sc.nextLine();
                    if (manager.existsEmail(email)) { System.out.println("이미 있는 회원입니다."); break; }
                    Member m = (grade == 2)
                            ? new VipMember(name, email, phone)
                            : new NormalMember(name, email, phone);
                    manager.add(m);   // 다형성: Member로 추가
                    System.out.println("추가되었습니다.");
                    break;
                }
                // case 2~6: findByEmail/findByName/printAll/update/delete 호출
                case 7: System.out.println("이용해주셔서 감사합니다."); return;
                default: System.out.println("1~7 중에서 선택하세요.");
            }
        }
    }
    static int readInt(Scanner sc) {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
}
