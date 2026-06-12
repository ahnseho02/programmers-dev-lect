import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ───── 요금제 선택 ─────
        System.out.println("=== 요금제를 선택하세요 ===");
        System.out.println("[1] Lite    : 최대 10명");
        System.out.println("[2] Basic   : 최대 20명");
        System.out.println("[3] Premium : 최대 30명");
        System.out.print("> ");
        int plan = Integer.parseInt(sc.nextLine().trim());
        MemberManager manager = new MemberManager(plan * 10);

        // ───── 메뉴 루프 ─────
        while (true) {
            System.out.println("\n[수행할 업무 - 현재 회원수 : "
                    + manager.getCount() + "/" + manager.getCapacity() + "]");
            System.out.println("[1]회원추가  [2]회원조회(메일)  [3]회원조회(이름)");
            System.out.println("[4]전체조회  [5]수정            [6]삭제  [7]종료");
            System.out.print("> ");
            int menu = Integer.parseInt(sc.nextLine().trim());

            switch (menu) {
                // ── 1. 회원 추가 ──────────────────────────────────────────
                case 1 -> {
                    if (manager.isFull()) {
                        System.out.println("❌ 회원이 꽉 찼습니다.");
                        break;
                    }
                    System.out.println("등급 선택 [1]일반  [2]VIP");
                    System.out.print("> ");
                    int grade = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("이름    > "); String name  = sc.nextLine();
                    System.out.print("이메일  > "); String email = sc.nextLine();
                    System.out.print("연락처  > "); String phone = sc.nextLine();

                    if (manager.existsEmail(email)) {
                        System.out.println("❌ 이미 존재하는 이메일입니다.");
                    } else {
                        // 등급에 따라 다른 객체 생성 → Member로 다형성 처리
                        Member m = (grade == 2)
                                ? new VipMember(name, email, phone)
                                : new NormalMember(name, email, phone);
                        manager.add(m);
                        System.out.println("✅ 회원이 추가되었습니다.");
                    }
                }

                // ── 2. 이메일로 조회 ──────────────────────────────────────
                case 2 -> {
                    System.out.print("조회할 이메일 > ");
                    String email = sc.nextLine();
                    Member m = manager.findByEmail(email);
                    if (m == null) System.out.println("❌ 해당 회원을 찾을 수 없습니다.");
                    else           m.printInfo();
                }

                // ── 3. 이름으로 조회 ──────────────────────────────────────
                case 3 -> {
                    System.out.print("조회할 이름 > ");
                    String name = sc.nextLine();
                    Member m = manager.findByName(name);
                    if (m == null) System.out.println("❌ 해당 회원을 찾을 수 없습니다.");
                    else           m.printInfo();
                }

                // ── 4. 전체 조회 ──────────────────────────────────────────
                case 4 -> manager.printAll();

                // ── 5. 수정 ───────────────────────────────────────────────
                case 5 -> {
                    System.out.print("수정할 회원 이메일  > "); String oldEmail = sc.nextLine();
                    System.out.print("새 이름             > "); String name     = sc.nextLine();
                    System.out.print("새 이메일           > "); String newEmail = sc.nextLine();
                    System.out.print("새 연락처           > "); String phone    = sc.nextLine();

                    if (manager.update(oldEmail, name, newEmail, phone))
                        System.out.println("✅ 수정이 완료되었습니다.");
                    else
                        System.out.println("❌ 해당 회원을 찾을 수 없습니다.");
                }

                // ── 6. 삭제 ───────────────────────────────────────────────
                case 6 -> {
                    System.out.print("삭제할 회원 이메일 > ");
                    String email = sc.nextLine();
                    if (manager.delete(email))
                        System.out.println("✅ 삭제가 완료되었습니다.");
                    else
                        System.out.println("❌ 해당 회원을 찾을 수 없습니다.");
                }

                // ── 7. 종료 ───────────────────────────────────────────────
                case 7 -> {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }

                default -> System.out.println("⚠️  1~7 사이의 번호를 입력하세요.");
            }
        }
    }
}
