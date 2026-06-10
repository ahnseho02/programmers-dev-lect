import java.util.Scanner;

public class Management {
    private String name;

    Pet pet = new Pet(name);

    public void feed(){
        pet.setFullness(pet.getFullness()+20);
        if (pet.getFullness()>=100){
            pet.setFullness(100);

        }

        pet.setHappy(pet.getHappy()+5);
        if(pet.getHappy()>=100){
            pet.setHappy(100);

        }
        System.out.println("먹이를 먹었어요");
    }

    public void play(){
        pet.setFullness(pet.getFullness()-10);
        if (pet.getFullness()>=100){
            pet.setFullness(100);

        }

        pet.setHappy(pet.getHappy()+20);
        if (pet.getHappy()<0){
            pet.setHappy(0);
        }

        if(pet.getHappy()>=100) {
            pet.setHappy(100);

            System.out.println("재미있게 놀았어요");
        }
    }

    public void condition(){
        System.out.println("포만감: "+pet.getFullness());
        System.out.println("행복: "+pet.getHappy());
    }

    public void print(){
        Scanner sc = new Scanner(System.in);
        System.out.println("반려동물의 이름을 지어주세요! : ");
        name = sc.nextLine();
        System.out.println(name+"이 태어났어요!");
        System.out.println("["+name+"]"+"포만감: "+pet.getFullness()+"행복: "+ pet.getHappy());

        while (true){
            int menu = menu();

            switch (menu){
                case 1:
                    feed();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    condition();
                    break;
                case 4:
                    System.out.println("종료되었습니다.");
                    return;
                default:
                    System.out.println("잘못입력하였습니다");
            }
        }
    }

    public int menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("1.먹이주기  2.놀아주기  3.상태보기  4.종료");
        choice = sc.nextInt();

        return choice;
    }
}
