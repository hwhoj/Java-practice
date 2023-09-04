import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/output01.txt");
            //writer = new FileWriter("src/output01.txt", true); //true 옵션을 넣으면 코드실행할때마다 문구가 계속 추가된다.
        } catch (IOException e) {
            //throw new RuntimeException(e); //에러 출력하는 구문이지만 FileWriter를 사용할 경우 다른 예외 처리를 해줘야함
            System.out.println("파일 생성에 실패 했습니다.");
            System.exit(1); //0으로 끝나면 정상 종료이지만 다른 수를 넣어서 정상종료되지 않았다는것을 알림
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("종료 하려면 입력 없이 엔터.");

        while (true){
        String input = scanner.nextLine();

        if (input.equals("")){
            System.out.println("파일 입력을 종료합니다.");
            break; //while문 빠져나가기
        }

        try {
            //writer.write("치킨은 살 안쪄요.\n"); // 파일에 문자열을 쓸 수 있는 코딩
            //writer.write("살은 내가 쪄요.");
            writer.write(input + "\n");
            //writer.close(); //파일을 다 사용했으니 파일의 변경 내용을 확인하고 파일을 닫겠다 라는 의미.
            //close()를 사용하지않으면 파일의 변경사항이 저장되지 않을 수 있으니 주의
        } catch (IOException e) {
            System.out.println("파일에 데이터를 쓰는데 실패했습니다.");
            System.exit(2);
        }
        }
        try {
            writer.close(); //파일을 다 사용한후 while문 바깥쪽에서 실행시켜줘야한다.
        } catch (IOException e) {
            System.out.println("파일에 닫기에 실패했습니다.");
            System.exit(3);
        }
    }
}
