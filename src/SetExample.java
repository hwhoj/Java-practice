import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        //set은 중복값을 허용하지 않는다.
        //List에 부모자식관계 ArrayList가 있는것처럼 Set에도 자식관계인 HashSet이 있다.
        Set<String> myFavoriteFoods = new HashSet<>();

        myFavoriteFoods.add("치킨");
        myFavoriteFoods.add("피자");
        myFavoriteFoods.add("치킨");

        myFavoriteFoods.remove("치킨");
        //중복값을 허용하지 않아 목록에 치킨이 1개만 있기때문에 출력시 피자만 출력된다

        System.out.println(myFavoriteFoods);
        //중복값을 허용하지 않으므로 치킨과 피자만 한번씩 출력된다

        //List는 순서가 있고 중복값을 허용한다. 특정위치의 요소에 접근 가능
        //set은 순서가 없고 중복값을 허용하지 않는다. 특정 위치의 값에 접근 불가

    }
}
