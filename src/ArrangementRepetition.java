import java.util.Scanner;

public class ArrangementRepetition {
    public static void main(String[] args) {

        //반복문 for
        for (int i = 0; i < 10; i = i + 1){
            System.out.println("현재 반복 횟수: " + i);
        }

        //중첩 for문 - 구구단
        for (int i = 2; i < 10; i = i + 1){
            for (int j = 1; j < 10; j = j + 1){
                System.out.println(i + " x " + j + " = " + i * j);
            }
        }

        //반복문 while
        int i = 0;
        while (i < 10){
            System.out.println("현재 반복 횟수 " + i);
            i = i + 1;
        }

        //while 심화
        String password = "abc123";
        Scanner scanner = new Scanner(System.in);

        System.out.println("비밀번호를 입력해 주세요.");
        String input = scanner.nextLine();

        while (input.equals(password) != true){
            System.out.println("비밀번호를 입력해 주세요");
            input = scanner.nextLine();
        }

        System.out.println("올바른 비밀번호를 입력했습니다.");

        /* while문을 do-while문으로 바꾸기
        String password = "abc123";
        Scanner scanner = new Scanner(System.in);

        String input;

        do{
            System.out.println("비밀번호를 입력해 주세요");
            input = scanner.nextLine();
        } while (input.equals(password) != true);
        System.out.println("올바른 비밀번호를 입력했습니다.");
         */

        //무한 반복문
        while (true) {
            System.out.println("비밀번호를 입력해주세요");
            String input1 = scanner.nextLine();

            if (input1.equals(password)){
                System.out.println("비밀번호가 일치합니다.");
                break;
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        //continue > 반복문의 처음으로 돌아간다
        for (int a = 0; a < 10; a = a + 1){
            if (a % 2 == 0) { //a가 짝수일경우
                continue;
            }
            System.out.println(a);
        }
    }
}
