import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HarzardInRooms {
    public static void main(String[] args) {
        //주변 방에 어떤 위험요소가 존재하는지 힌트 주기

        int[] rooms = {0, 1, 2, 3};
        //4개의 방을 생성

        String BAT = "Bat";
        String PIT = "Pit";
        String WUMPUS = "Wumpus";
        //위험 요소 3개
        String NOTHING = "Nothing";
        //아무 위험 없음

        String[] hazards = {NOTHING, BAT, PIT, WUMPUS};
        //각 방에 위험요소를 배치함

        HashMap<String, String> hazardMessages = new HashMap<>();
        //메세지를 저장할 맵 변수를 저장한다.

        hazardMessages.put(WUMPUS, "\"어디선가 끔찍한 냄새가 난다.\"");
        hazardMessages.put(BAT, "\"어디선가 부스럭거리는 소리가 들린다.\"");
        hazardMessages.put(PIT, "\"바람이 부는 소리가 들리는 것 같다.\"");
        hazardMessages.put(NOTHING, "\"저 방에는 아무것도 없는 것 같다.\"");
        //위험 요소에 해당하는 대사들을 입력

        int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 2, 1}};
        //각 방에서 이동할 수 있는 다음 방들의 목록

        int currentRoom = 0;
        //현재 몇 번 방에 위치하고있는지를 정의

        Scanner scanner = new Scanner(System.in);
        //사용자 입력을 받기 위해서 스캐너를 선언

        while (true){
            System.out.println("지금 " + currentRoom + "번 방에 있습니다.");

            int[] nextRooms = links[currentRoom];
            //현재 방들과 인접한 방들위 목록을 가져옴

            for (int nextRoom : nextRooms){
                String hazard = hazards[nextRoom]; //그 방에위치한 위험 요소를 가져옴
                String message = hazardMessages.get(hazard); // 그위험요소에 대한 메세지를 가져옴
                System.out.println(message); //위험요소에대한 메세지 출력
            }

            System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요");
            //현재 위치와 방 번호를 출력
            System.out.println(Arrays.toString(nextRooms));
            //위험요소의 메세지를 보고 어느방으로 이동할지 결정

            int roomNumber = scanner.nextInt();
            //사용자로부터 정수를 입력받음

            currentRoom = roomNumber;
            //현재 위치의 방을 사용자가 입력한 정수로 변경해준다.
            //그럼 다음 변경된 방의 위치를 출력해주고 이동할 방번호를 입력하는 루프가반복된다.

        }
    }
}
