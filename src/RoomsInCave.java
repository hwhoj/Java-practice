import java.util.Arrays;
import java.util.Scanner;

public class RoomsInCave {
    public static void main(String[] args) {
        //동굴의 방과 통로 그리고 플레이어의 이동

        int[] rooms = {0, 1, 2, 3};
        //4개의 방을 선언

        int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 1, 2}};
        //정수형 2차원 배열을 선언하고 각 방에서 이동할 수있는 방들의 목록을 정의

        int currentRoom = 0;
        //현재 몇 번 방에 위치하고있는지를 정의

        Scanner scanner = new Scanner(System.in);
        //사용자 입력을 받기 위해서 스캐너를 선언

        while (true){
            System.out.println("지금 " + currentRoom + "번 방에 있습니다.");
            System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요");
            //현재 위치와 방 번호를 출력

            System.out.println(Arrays.toString(links[currentRoom]));
            //현재 방에서 이동할 수 있는 방들의 목록을 표시해줌 currentRoom 초기값이 0이므로 0번방에서 이동할 수 있는 방이 출력됨

            int roomNumber = scanner.nextInt();
            //사용자로부터 정수를 입력받음

            currentRoom = roomNumber;
            //현재 위치의 방을 사용자가 입력한 정수로 변경해준다.
            //그럼 다음 변경된 방의 위치를 출력해주고 이동할 방번호를 입력하는 루프가반복된다.

        }
    }
}
