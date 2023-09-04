import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream("src/acronym.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(inputStream);
        /*
        //입력 소스로부터 값을 읽어 들이기 위해서 스캐너를 사용한다
        String line = scanner.nextLine(); //데이터를 한줄 읽는다
        System.out.println(line);
        String line2 = scanner.nextLine(); //데이터를 한줄 읽는다
        System.out.println(line2);

        String line3 = scanner.nextLine(); //데이터를 한줄 읽는다
        System.out.println(line3);

        2줄인 파일에 3줄을 읽어오게하면 예외처리가 발생한다. 긴 문장의 파일을 불러올때는
        몇 줄이 있는지 알기 힘드니 반복문을 통해 파일을 불러오는 편이 좋다.
        */

        while (scanner.hasNextLine()){//hasNextLine()은 다음 줄이 있는지 판단한다 있다면 true 없다면 false 반환
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
