package Bingo;
import java.util.*;

public class BingoGame {
    static final int SIZE = 5;        // 판 크기 5x5
    static final int MAX = 25;        // 숫자 1~25

    int[][] arr = new int[SIZE][SIZE];

    BingoGame(int col, int row) {
        int [][]array= new int[SIZE][SIZE];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                arr[i][j]=(int)(Math.random()*MAX);
            }
        }
    }



    public void play() {
        System.out.println("===== 빙고 게임 =====");
        System.out.println("컴퓨터와 번갈아 숫자를 불러 빙고를 완성하세요!");
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];


    }
}