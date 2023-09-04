import java.util.Random;
import java.util.Scanner;

public class RandomInteger {
    public static void main(String[] args) {
        /*
        //랜덤한 숫자 불러오기
        Random random = new Random();

        int randomNumber = random.nextInt(256);
        System.out.println(randomNumber);


        //지연시간 추가하기 Thread.sleep
        System.out.println("지금 무슨 생각하고있는지 맞춰볼게요");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("치킨!");*/

        System.out.println("지금부터 0~255 사이의 숫자를 하나 뽑겠습니다.");
        System.out.println("여러분은 제가 뽑은 숫자를 맞춰야 합니다.");

        Random random = new Random();
        int randomNumber = random.nextInt(256); //255까지의 임의의 숫자를 불러온다.

        Scanner scanner = new Scanner(System.in); //사용자에게 값을 입력 받음

        for (int i = 0; i < 8; i = i + 1){
            System.out.println(8 - i + "번의 기회가 남았습니다.");
            System.out.println("추측한 숫자를 입력하세요");

            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);

            if (randomNumber == guess){
                System.out.println("짝짝짝! 정답입니다!");
                break; //for문 탈출
            } else if (randomNumber < guess) {
                System.out.println("제가 생각한 숫자가 더 작습니다.");
            } else {
                System.out.println("제가 생각한 숫자가 더 큽니다.");
            }
            if (i == 7 ) {
                System.out.println("더이상 기회가 남지 않았습니다.");
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}
