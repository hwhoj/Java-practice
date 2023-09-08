import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class HuntTheWumpus {
    public static Integer[] rooms = {
            0,  1,  2,  3,  4,  5,  6,  7,  8,  9,
            10,11, 12, 13, 14, 15, 16, 17, 18, 19
    };
    //0번부터 19번 까지 20개의 방을 선언

    public static Integer[][] links = {
            {1, 7, 4},    {0, 9, 2},    {1, 11, 3},   {2, 13, 4},   {3, 0, 5},
            {4, 14, 6},   {5, 16, 7},   {6, 0, 8},    {7, 17, 9},   {8, 1, 10},
            {9, 18, 11},  {10, 2, 12},  {11, 19, 13}, {12, 3, 14},  {13, 5, 15},
            {14, 19, 16}, {15, 6, 17},  {16, 8, 18},  {17, 10, 19}, {18, 12, 15}
    };
    //각 방에서 이동할 수 있는 방 번호들을 모아놓은 2차원 배열
    //ex)0번 방에서 7번방으로 갔다면 7번방에서도 0번방으로 갈 수 있어야함

    public static String WUMPUS = "Wumpus";
    public static String BAT = "Bat";
    public static String PIT = "Pit";
    public static String NOTHING = "Nothing";
    //위험요소를 나타내는 문자열들

    public static ArrayList<String> hazards = new ArrayList<>();
    //각 방에 위치한 위험요소를 표현하는 용도의 리스트
    public static HashMap<String, String> harzardMessages = new HashMap<>();
    //게임의 룰에 따라 주변방에 어떤 위험요소가 있느냐에 따라 주인공이 대사를 독백처럼 출력하게됨
    //위험요소의 이름을 키로하고 대사를 값으로 줬다

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    //사용자 이름을 받고, 랜덤한 방을 선택하는 쓰임새가 잦은 변수들을 멤버 변수로 빼둠

    public static boolean gameOver = true;
    //게임 오버에 대한 여부를 나타넨 불린 변수

    public static int currentRoom;
    //플레이어의 현재 위치
    public static int arrowCount;
    //현재 플레이어가 가진 화살의 개수
    public static int wumpusRoom;
    //현재 움퍼스의 위치

    public static void main(String[] args) {
        showIntro();
        //게임을 시작하면 보여지는 인트로 화면

        initializeStaticValues();
        //게임이 호출되는 내내 변하지 않는 값들을 초기화 해 주는 메소드

        while (true){
            initializePlayVariables();
            //플레이어와 관련된 변수 값들을 초기화 해준다.

            setupHazards();
            //각 방의 위험요소들을 랜덤하게 배치한다.

            delay(1000);
            System.out.println("\n...");
            delay(1000);
            System.out.println("...");
            delay(1000);
            System.out.println("동굴에 들어왔습니다...\n");
            delay(1000);
            System.out.println("\"섬뜩한 곳이군.\"");
            delay(1000);
            //독백하는 듯한 느낌을 주기위해 1초 마다 텀을 주고 대사가 출력된다.
            //thread.sleep? 을 호출하는 코드

            game();
            //게임 1회 분량의 게임이라는 메소드를 실행
            selectReplay();
            //게임을 종료할지 다시실행할지 선택하는 메소드
        }
    }

    private static void showIntro(){
        try {
            FileInputStream inputStream = new FileInputStream("src/intro.txt");
            //인트로 파일의 내용을 읽어 한줄씩 끝까지 출력해 주는 기능
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
                delay(500);
            }
            //인트로 파일의 내용을 한줄씩 0.5초마다 읽어준다.
        }catch (FileNotFoundException e){
            System.out.println("인트로를 읽을 수 없어 생략 합니다.");
        }

    }

    private static void initializePlayVariables(){
        gameOver = false;
        //게임이 시작되었으니 게임 오버를 false로 바꿔줌
        currentRoom = random.nextInt(rooms.length);
        //플레이어의 위치를 랜덤하게 결정해준다.
        arrowCount = 5;
        //화살의 갯수를 5개로 초기화 해준다
    }

    private static void selectReplay(){
        System.out.println("게임이 끝났습니다. 다시 플레이 하시겠습니까?");

        while (true){
            System.out.println("(0: 종료, 1: 다시 플레이)");
            String action = scanner.nextLine();

            if (action.equals("0")){
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }

            else if (action.equals("1")) {
                System.out.println("게임을 다시 플레이 합니다.");
                break;
            }

            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void game(){
        while (gameOver == false){
            System.out.println("\n당신은 " + currentRoom + "번 방에 있습니다.");
            System.out.println("행동을 선택하세요.");
            System.out.println("1. 이동");
            System.out.println("2. 화살쏘기");
            System.out.println("3. 통로 목록");
            System.out.println("0. 플레이 종료");
            //사용자가 어느 방에 있는지 출력해주고, 4가지 행동을 제시

            String action = scanner.nextLine();
            //사용자 입력을 받는다.

            if (action.equals("1")){
                //사용자가 1. 이동을 선택했을때

                Integer[] nextRooms = links[currentRoom];
                //links로부터 현재 위치에서 갈 수있는 방들의 번호들읋 가져와 플레이어에게 알려준다

                System.out.println("\n몇번 방으로 이동하시겠습니까?");
                System.out.println(Arrays.toString(nextRooms));

                String nextRoomInput = scanner.nextLine();
                //사용자로부터 다시 방 번호를 입력받는다

                int nextRoom = parseIntegerOrNegative1(nextRoomInput);

                if (Arrays.asList(nextRoom).contains(nextRoom)){
                    //현재 위치에서 갈 수 있는 방 목록에 사용자가 입력한 방 번호가 있는지를 판단.
                    move(nextRoom);
                    //갈수있다면 move메소드
                } else {
                    System.out.println("선택한 방으로는 이동할 수 없습니다.");
                    //갈수 없다면 이동불가 메세지 출력
                }
            }

            else if (action.equals("2")) {
                Integer[] nextRooms = links[currentRoom];
                //주변 방들의 목록을 가져온다

                System.out.println("\n몇 번 방에 화살을 쏘시겠습니까?");
                System.out.println(Arrays.toString(nextRooms));
                //화살을 쏠 수 있는 방들의 목록을 출력해준다

                String targetRoomInput = scanner.nextLine();
                //사용자로부터 방 번호를 입력 받는다
                int targetRoom = parseIntegerOrNegative1(targetRoomInput);
                //정수로 변환한다.

                if (Arrays.asList(nextRooms).contains(targetRoom)){
                    //연결되어 있는 방이 맞다면
                    shoot(targetRoom);
                    //shoot메소드를 실행
                } else {
                    System.out.println("선택한 방에는 화살을 쏠 수 없습니다.");
                }
                
            }

            else if (action.equals("3")) {
                System.out.println("현재 방에 연결된 통로는 다음과 같습니다.");
                System.out.println(Arrays.asList(links[currentRoom]));
            }

            else if (action.equals("0")) {
                System.out.println("게임 플레이를 종료합니다.");
                gameOver = true;
            }

            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void initializeStaticValues(){
        harzardMessages.put(WUMPUS, "\"어디선가 끔찍한 냄새가 난다.\"");
        harzardMessages.put(BAT, "\"어디선가 부스럭거리는 소리가 들린다.\"");
        harzardMessages.put(PIT, "\"바람이 부는 소리가 들리는 것 같다.\"");
        harzardMessages.put(NOTHING, "\"저 방에는 아무것도 없는것 같다.\"");

    }

    public static void setupHazards(){
        //위험요소들을 배치하는 메소드

        if (hazards.size() == 0){
        //위험요소들의 갯수가 0이면 = 프로그램이 지금 막 실행되었다.

            for (int i = 0; i < rooms.length; i = i + 1){
                hazards.add(NOTHING);
                // 방 갯수 만큼 NOTHING을 추가해 준다.
                // 프로그램 실행 후 2번째 플레이 때는 이부분은 실행되지 않는다. 그래서 위험요소의 배열의 개수는 방 갯수와 동일하게 유지된다
            }
        }

        for (int i = 0; i < rooms.length; i = i + 1){
            hazards.set(i, NOTHING);
            //게임이 재시작 되었을 때 모든 방의 위험요소를 비워주는 역할
        }

        String[] ordinals = {WUMPUS, BAT, BAT, BAT, PIT, PIT};
        //배치할 위험 요소들의 순서, 출현 빈도

        for (String hazard : ordinals){
            int room;
            //랜덤한 방 번호를 나타낼 룸이라는 변수 선언

            while (true){
                //무한히 반복하는 while 루프 안에서

                room = random.nextInt(rooms.length);
                //랜덤한 적절한 방을 선택한다

                if (isTooCloseWihtPlayer(room)){
                    //위험요소가 플레이어의 초기 위치와 가깝지 않은지 판단하는 메소드
                    //true를 반환 받고 너무 가깝다고 판단이 되면 continue를 통해 while문의 첫줄로 돌아가서 다시 랜덤한 방을 설정
                    continue;
                }

                if (hazards.get(room).equals(NOTHING)){
                    //위험요소를 위치시키려는 방에 또다른 위험요소가 있는지 확인
                    //이 방에 위험요소가 아무것도 없으면 break를 통해서 현재 선택한 방 번호를 유지한채 while루프를 빠져나간다.
                    break;
                }
            }

            hazards.set(room, hazard);
            //선택된 방 번호를 통해서 위험요소들의 room번째의 이번 순서의 위치시킬 위험요소를 set 해준다


            if (hazard.equals(WUMPUS)){
                //배치될 위험요소가 움퍼스라면 room번째의 순서를 움퍼스의 초기위치로 설정한다
                wumpusRoom = room;
            }
        }
    }

    public static boolean isTooCloseWihtPlayer(int room){
        if (currentRoom == room){
            //플레이어의 현재 위치와 랜덤하게 선택 된 방 번호가 같은지를 확인
            return true;
            //게임시작시에는 플레이어와 위험요소가 동일한곳에 있어서는 안되기때문에 true 반환
        }

        List<Integer> linkedRooms = Arrays.asList(links[currentRoom]);
        //플레이어의 초기위치에서 이동 할 수 있는 주변 방들의 목록을 가져와
        if (linkedRooms.contains(room)){
            //위험요소가 위치될 방이 플레이어의 초기 위치와 인접해 있는지룰 확인
            return true;
            //그렇다면 너무 가깝다는 의미의 true 반환
        }

        return false;
        //이에 해당하지않는다면 가깝지 않다는 의미로 false 반환
    }

    public static int parseIntegerOrNegative1(String input){
        //String을 Innteger로 바꾸거나 -1을 반환하는 메소드
        try{
            return Integer.parseInt(input);
            //매개변수로 들어온 String을 Integer로 변환하는것을 시도한다.
        } catch (NumberFormatException e){
            return -1;
            //예외가 발생했을때 -1을 반환
        }
    }

    public static void shoot(int room){
        arrowCount = arrowCount -1;

        delay(1000);
        System.out.println("슈웅");
        delay(300);

        if (hazards.get(room).equals(WUMPUS)){
            System.out.println("푸슉!");
            delay(1000);
            System.out.println("\"쿠에에에엑!\"");
            delay(1000);
            System.out.println("축하합니다. 당신은 움퍼스를 죽였습니다!");
            gameOver = true;
        }
        else {
            System.out.println("(...)");
            delay(1000);
            System.out.println("\"화살만 낭비했군.\"");

            if (arrowCount == 0){
                delay(300);
                System.out.println("\"이런, 화살이 남지 않았다!\"");
                delay(300);
                System.out.println("당신은 움퍼스 사냥에 실패했습니다.");
                gameOver = true;
            }

            else if (random.nextInt(4) != 0) {
                //화살이 다 떨어지지 않았다면 75%확률로 움퍼스를 깨운다
                System.out.println("당신은 움퍼스를 깨웠습니다.");
                delay(1000);

                Integer[] nextRooms = links[wumpusRoom];
                //움퍼스가 있는 방들에서 갈 수있는 목록들은 가져온다

                int nextRoom = nextRooms[random.nextInt(3)];
                //그 방들중 하나를 랜덤하게 선택한다

                if (hazards.get(nextRoom).equals(NOTHING)){
                    //만약 선택된 방에 아무것도 없다면 움퍼스 이동처리를 한다
                    hazards.set(wumpusRoom, NOTHING);
                    //현재 움퍼스가 있는방은 NOTHING을 넣고
                    hazards.set(nextRoom, WUMPUS);
                    //랜덤하게 선택된 방에 움퍼스를 위치시킨다
                    wumpusRoom = nextRoom;
                    //움퍼스가 위치한 방 번호를 움퍼스룸 변수에 대입한다
                }

                if (wumpusRoom == currentRoom){
                    System.out.println("\"으아아아아악!\"");
                    delay(500);
                    System.out.println("움퍼스가 당신을 잡아 먹었습니다.");
                    gameOver = true;
                }

                else if (wumpusRoom == nextRoom) {
                    System.out.println("움퍼스가 도망갔습니다.");
                }
            }
        }

    }

    private static void delay(int i) {
        try {
            Thread.sleep(i); // 단위 ms
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static void move(int room){
        currentRoom = room;
        //사용자의 위치를 입력한 방 번호로 변경
        System.out.println(currentRoom + "번 방으로 이동했습니다.");

        String hazard = hazards.get(currentRoom);
        //그 방에있는 위험요소를 가져온다.

        delay(1000);

        if (hazard.equals(WUMPUS)){
            System.out.println("\"으아아아아악!\"");
            delay(300);
            System.out.println("움퍼스가 당신을 잡아먹었습니다.");
            gameOver = true;
        }

        else if (hazard.equals(PIT)) {
            System.out.println("\"으아아아아아아~~\"");
            delay(1000);
            System.out.println("쿵!");
            delay(300);
            System.out.println("당신은 구덩이에 빠졌습니다.");
            delay(300);
            System.out.println("더이상 움퍼스를 사냥할 수 없습니다.");
            gameOver = true;
        }

        else if (hazard.equals(BAT)) {
            System.out.println("쿵!");
            delay(300);
            System.out.println("박쥐가 당신을 잡아 다른 방에 떨어뜨렸습니다.");
            //박쥐가 플레이어를 다른 방으로 이동시켰다는 메세지 출력

            do{
                currentRoom = random.nextInt(rooms.length);
                //랜덤한 방을 선택해보고
            } while (hazards.get(currentRoom).equals(BAT));
            //while문의 반복조건으로 그방에 박쥐가 있는지 판단한다.
            //박쥐가 없는 랜덤한 방을 찾아 사용자의 위치를 변경시킨다

            hazards.set(room, NOTHING);
            //박쥐와 사용자가 이동하므로 사용자가 이동하려고 했던 방은 NOTHING으로 바꿔준다

            while (true){
                int newBatRoom = random.nextInt(rooms.length);
                //랜덤한 방을 고르고

                if (newBatRoom == currentRoom){
                    //플레이어와 옮겨간 위치가 같다면 위로 돌아가서 다시 랜덤한 방을 고른다
                    continue;
                }

                if (hazards.get(newBatRoom).equals(NOTHING)){
                    //선택된 랜덤한 방에 다른 위험 요소가 있다면 다시 반복.
                    hazards.set(newBatRoom, BAT);
                    //아무것도 없다면 그곳에 박쥐를 위치시킨다
                    break; //while문 탈출
                }
            }

            move(currentRoom);
            //한 번 더 플레이어의 이동 처리를 해준다

        }
        else {
            //위험요소가 아무것도 없는 경우
            List<Integer> nextRooms = Arrays.asList(links[currentRoom]);
            //links에서 현재 방에서 갈 수 있는 방들의 목록을 가져온다


            System.out.println("\n(연결되어 있는 통로를 살핀다.)");
            for (int nextRoom : nextRooms){
                //통로로 연결되어있는 방들의 목록을 for each문으로가져온다
                delay(700);
                String hazardAround = hazards.get(nextRoom);
                //방에 있는 위험 요소를 가져와서
                System.out.println(harzardMessages.get(hazardAround));
                //대사를 담은 Map으로부터 위험요소에 해당하는 대사를 가져와서 출력해준다
            }
            Collections.shuffle(nextRooms);
            //방의 목록을 섞어준다. 이유는 대사가 출력되는 순서에 따라서 몇번째 방에 어떤 위험요소가 있는지 정확하게 알려주지 않기위해
        }
    }




}
