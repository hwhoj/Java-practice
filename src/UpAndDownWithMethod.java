import java.util.Random;
import java.util.Scanner;

public class UpAndDownWithMethod {
    public static int randomNumber; //랜덤한 숫자를 전역에서 사용
    public static Scanner scanner = new Scanner(System.in);
    //사용자 입력을 받는 인터페이스는 프로그램이 실행될때 한번만 실행해서 계속 재사용할수있다
    public static void main(String[] args) {
        Random random = new Random();
        randomNumber = random.nextInt(256);

        int attempt = 0; //시도 횟수

        while (attempt < 8){ //시도횟수가 8보다 작을동안만 반복
            boolean isCorrect = play();

            if (isCorrect){
                break;
            }

            attempt = attempt + 1;
            System.out.println(attempt + "회 시도하였습니다.");
        }

        System.out.println("게임을 종료합니다.");

    }

    public static boolean play(){
        System.out.println("숫자를 입력하세요.");
        int input = scanner.nextInt();

        if (input == randomNumber){
            System.out.println("짝짝짝, 정답입니다.");
            return true;
        } else if (input > randomNumber) {
            System.out.println("더 작게요");
        } else {
            System.out.println("더 크게요");
        }

        return false;
    }
}
