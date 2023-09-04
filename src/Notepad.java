import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { //사용자가 종료하기 전까지는 메모 읽기와 쓰기를 반복한다
            System.out.println("원하는 작업 번호를 입력해주세요.");
            System.out.println("1. 메모 읽기");
            System.out.println("2. 새 메모");
            System.out.println("3. 종료");

            int taskNum; //유저로부터 입력받을 번호를 저장할 변수

            try{ //사용자 변수를 입력받아. 입력값을 정수로 변환해 taskNum에 대입한다.
                String input = scanner.nextLine();
                taskNum = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력 입니다.");
                continue; //반복문의 처음으로 돌아감
            }

            if (taskNum == 1){
                System.out.println("메모 파일명을 입력하세요.");

                String fileName = scanner.nextLine();

                FileInputStream inputStream = null;

                try {
                    inputStream = new FileInputStream(fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("파일이 존재하지 않습니다.");
                    continue;
                } //여기까지는 정상적인 파일이 열려서 읽을 준비가 되었다는것

                System.out.println(fileName + "의 내용을 출력합니다.");

                Scanner reader = new Scanner(inputStream);
                //파일의 내용을 읽기위해 스캐너를 한 개 더 생성

                while (reader.hasNextLine()){
                    System.out.println(reader.nextLine());
                }
                System.out.println("\n");

                reader.close();
            } else if (taskNum == 2) {
                System.out.println("저장 할 메모 파일명을 입력하세요.");

                String fileName = scanner.nextLine();

                FileWriter writer = null;

                try {
                    writer = new FileWriter(fileName);
                } catch (IOException e) {
                    System.out.println("파일 생성에 실패했습니다.");
                    continue;
                }

                System.out.println("메모할 문자열을 입력하세요.");
                System.out.println("종료: 빈 줄에서 엔터 입력");

                while (true){
                    String input = scanner.nextLine();

                    if (input.equals("")){
                        break;
                    }

                    try {
                        writer.write(input);
                        writer.write("\n");
                    } catch (IOException e) {
                        System.out.println("파일에 문자열을 쓰지 못했습니다.");
                    }
                }

                try{
                    writer.close();
                } catch (IOException e) {
                    System.out.println("파일을 닫는데 실패했습니다.");
                }
            } else if (taskNum == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }
}
