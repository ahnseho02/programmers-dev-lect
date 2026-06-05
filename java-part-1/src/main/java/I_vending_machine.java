import java.util.Scanner;

public class I_vending_machine {

    // 음료 가격
    static final int COKE = 500, CIDER = 500, FANTA = 300, WATER = 200;

    // 메뉴 출력
    public static void printMenu(int totalMoney) {
        System.out.println("============== 자판기 ==============");
        System.out.println("[1]콜라 : 500");
        System.out.println("[2]사이다 : 500");
        System.out.println("[3]환타 : 300");
        System.out.println("[4]물 : 200");
        System.out.println("[5]돈 넣기");
        System.out.println("[6]종료");
        System.out.println("현재 금액 : " + totalMoney);
        System.out.println("====================================");
    }

    // 메뉴 선택
    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 메뉴를 선택하시오 : ");
        return sc.nextInt();
    }

    // 돈 입력
    public static int getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("돈을 넣으시오 : ");
        return sc.nextInt();
    }

    // 금액 계산
    public static int calcMoney(int totalMoney, int price) {
        return totalMoney - price;
    }

    // 잔액 부족
    public static void calcMoneyException() {
        System.out.println("잔액이 부족합니다.");
    }

    public static void main(String[] args) {

        int totalMoney = 0;

        while (true) {

            printMenu(totalMoney);

            int choice = getChoice();
            int result;

            switch (choice) {

                case 1:
                    result = calcMoney(totalMoney, COKE);

                    if (result < 0) {
                        calcMoneyException();
                    } else {
                        totalMoney = result;
                        System.out.println("콜라가 나왔습니다.");
                    }
                    break;

                case 2:
                    result = calcMoney(totalMoney, CIDER);

                    if (result < 0) {
                        calcMoneyException();
                    } else {
                        totalMoney = result;
                        System.out.println("사이다가 나왔습니다.");
                    }
                    break;

                case 3:
                    result = calcMoney(totalMoney, FANTA);

                    if (result < 0) {
                        calcMoneyException();
                    } else {
                        totalMoney = result;
                        System.out.println("환타가 나왔습니다.");
                    }
                    break;

                case 4:
                    result = calcMoney(totalMoney, WATER);

                    if (result < 0) {
                        calcMoneyException();
                    } else {
                        totalMoney = result;
                        System.out.println("물이 나왔습니다.");
                    }
                    break;

                case 5:
                    totalMoney += getMoney();
                    break;

                case 6:
                    System.out.println("잔돈 " + totalMoney + "원이 반환되었습니다.");
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }
}