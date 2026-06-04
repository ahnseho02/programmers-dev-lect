import java.util.Scanner;

public class Test_3 {
    static final int COKE =500, CIDER = 700, FANTA = 300, WATER=200;

    public static void calculator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("가지고 있는 돈을 입력하시오.");
        int totalMoney= sc.nextInt();

        while (true){
            printMenu(totalMoney);
            System.out.println("가지고 있는 돈"+totalMoney);
            System.out.println("선택");
            int choice = sc.nextInt();

            if(choice == 1){
                totalMoney = totalMoney - COKE;
                System.out.println("콜라를 선택했습니다.");
                System.out.println("가지고 있는 돈" + totalMoney);

                if (totalMoney<0){
                    System.out.println("돈이 부족합니다.");
                    break;
                }

            } else if (choice ==2) {
                totalMoney = totalMoney - CIDER;
                System.out.println("사이다를 선택했습니다.");
                System.out.println("가지고 있는 돈" + totalMoney);

                if (totalMoney<0){
                    System.out.println("돈이 부족합니다.");
                    break;
                }

            } else if (choice ==3) {
                totalMoney = totalMoney - FANTA;
                System.out.println("환타를 선택했습니다.");
                System.out.println("가지고 있는 돈" + totalMoney);

                if (totalMoney<0){
                    System.out.println("돈이 부족합니다.");
                    break;
                }

            } else if (choice ==4) {
                totalMoney = totalMoney - WATER;
                System.out.println("물을 선택했습니다.");
                System.out.println("가지고 있는 돈" + totalMoney);

                if (totalMoney<0){
                    System.out.println("돈이 부족합니다.");
                    break;
                }
            } else if (choice==6) {
                System.out.println("종료");
                return;

            } else {
                System.out.println("입력이 잘못되었습니다.");
            }

        }
    }
    public static void printMenu(int totalMoney) {
        System.out.println("================================= 자판기 ================================");
        System.out.println("[1]콜라-500원 [2]사이다-700원 [3]환타-300원 [4]물-200원 [5]돈넣기 [6]종료");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        calculator();
    }

}
