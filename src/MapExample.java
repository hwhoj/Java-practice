import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample {
    public static void main(String[] args) {
        //키와 값을 같이 목록화 하는 구조
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("chicken", "닭");
        dictionary.put("hippo", "하마");

        //map에도 목록의 갯수를 반환하는 size메소드가있다.
        System.out.println(dictionary.size() + " 개의 단어가 있습니다.");

        //특정 키의 값을 null 바꿔서 값을 제거할 수 있다.
        //dictionary.put("chicken", null); 이 방법은 값만 없애기 때문에 리스트에 키값만 남아있게된다
        dictionary.remove("chicken");

        //map이 비어있는지 확인하는 메소드 isEmpty()
        if (dictionary.isEmpty()){
            System.out.println("단어가 하나도 없습니다.");
        } else {
            System.out.println(dictionary.size() + " 개의 단어가 있습니다.");
        }

        //map에서는 키를 불러오면 값을 반환한다
        System.out.println(dictionary.get("chicken"));

        //간단한 영한 단어사전 만들기
        Scanner scanner = new Scanner(System.in);

        String english = scanner.nextLine();
        String korean = dictionary.get(english);

        if (korean == null){
            System.out.println("사전에 존재하지 않는 단어입니다.");
        } else {
            System.out.println(english + "는 " + korean + "입니다.");
        }

        //키의 목록만 가져오는 방법 dictionary.keySet, 값의 목록만 가져오는법 dictionary.values
        Collection<String> keys = dictionary.keySet();

        for (String english1 : keys) {
            System.out.println(english1);
        }

    }
}
