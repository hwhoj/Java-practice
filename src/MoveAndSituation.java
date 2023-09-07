import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MoveAndSituation {
    public static int[] rooms = {0, 1, 2, 3};
    public static int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 1, 2}};

    public static String BAT = "Bat";
    public static String PIT = "Pit";
    public static String WUMPUS = "Wumpus";
    //위험 요소 3개
    public static String NOTHING = "Nothing";
    //아무 위험 없음

    public static String[] hazards = {NOTHING, BAT, PIT, WUMPUS};
    //각 방에 위험요소를 배치함
    public static int currentRoom = 0;
    //현재 몇 번 방에 위치하고있는지를 정의
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //사용자 입력을 받기 위해서 스캐너를 선언

        while (true){
            System.out.println("지금 " + currentRoom + "번 방에 있습니다.");
            //현재 위치와 방 번호를 출력

            int[] nextRooms = links[currentRoom];
            //현재 방과 인접한 방들을 가져온다

            System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요");
            System.out.println(Arrays.toString(nextRooms));
            //현재 방에서 이동할 수 있는 방들의 목록을 표시해줌(nextRooms)
            //currentRoom 초기값이 0이므로 0번방에서 이동할 수 있는 방이 출력됨

            int roomNumber = scanner.nextInt();
            //사용자로부터 정수를 입력받음

            move(roomNumber);

        }

    }
 /**
    플레이어가 이동했을 떄 이동과 그 뒤의 이벤트들을 처리하는 메소드입니다.
    이동을 하게 되면 그 방에 어떤 위험요소가 있는지를 판단하고 각 위험요소에 해당하는 이벤트를 처리합니다.
 */
    private static void move(int room){
        currentRoom = room;
        //입력한 방으로 이동한다.

        String hazardInRoom = hazards[currentRoom];
        //변경된 방의 위험 요소를 가져온다.

        if (hazardInRoom.equals(WUMPUS)){ //현재 방에 움퍼스가 있는경우
            System.out.println("움퍼스에게 잡아먹혔습니다.");
            //TODO.game over
        } else if (hazardInRoom.equals(PIT)) { //현재 방에 구덩이가 있는경우
            System.out.println("구덩이에 빠졌습니다.");
            //TODO.game over
        } else if (hazardInRoom.equals(BAT)) { //현재 방에 박쥐가 있는 경우
            System.out.println("박쥐가 당신을 잡아 다른 방에 떨어트렸습니다.");

            Random random = new Random();
            //사용자의 위치를 랜덤하게 옮겨주기 위해 랜덤 객체를 생성함

            do {
                currentRoom = random.nextInt(rooms.length);
                //방들의 갯수 안에서 랜덤한 숫자를 하나 가져와서 플레이어의 위치에 대입을 해준다
            } while (hazards[currentRoom].equals(BAT));
            //랜덤으로 위치한 방에 박쥐가 또 존재한다면 반복문을 다시 돈다. 박쥐가 안나올때까지

            hazards[room] = NOTHING;
            //박쥐가 없는 위로 사용자 위치를 변경했다면, 위험요소를 없음으로 변경한다
            //room은 플레이어가 이동하려고 입력했던 방 번호이므로 박쥐가 존재했던 방이니 박쥐를 없애줘야한다.


            while (true){
                int newBatRoom = random.nextInt(rooms.length);
                //방들의 갯수 안에서 랜덤한 숫자를 하나 가져와서 박쥐의 위치를 랜덤하게 옮겨주기위한 랜덤 객체 생성

                if (newBatRoom == currentRoom){
                    //플레이어의 위치와 비교해보고 플레이어의 위치와 같이 않을때까지 반복
                    continue;
                }

                if (hazards[newBatRoom].equals(NOTHING)){
                    //방의 위험요소가 없을때 박쥐를 위치시키고 반복문 종료
                    hazards[newBatRoom] = BAT;
                    break;
                }
            }

            move(currentRoom);
        }

    }
}

