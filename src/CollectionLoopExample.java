import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionLoopExample {
    public static void main(String[] args) {
        List<String> foods = new ArrayList<>();

        foods.add("치킨");
        foods.add("피자");
        foods.add("무말랭이");

        for (String food : foods) {
            System.out.println(food + " 맛있어요");
        }

        Set<String> foods1 = new HashSet<>();

        foods1.add("치킨");
        foods1.add("피자");
        foods1.add("무말랭이");

        for (String food : foods1) {
            System.out.println(food + " 맛있어요");
        }

        //리스트가 비어있는지 확인하는 방법: size()메소드
        if (foods.size() == 0){
            System.out.println("목록이 비어있습니다.");
        } else {
            System.out.println("총 " + foods.size() + "개의 음식 목록이 있습니다.");
        }

        //리스트가 비어있는지 확인하는 방법: isEmpty()메소드
        if (foods.isEmpty()){
            System.out.println("목록이 비어있습니다.");
        } else {
            System.out.println("총 " + foods.size() + "개의 음식 목록이 있습니다.");
        }
    }
}
