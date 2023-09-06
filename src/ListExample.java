import java.util.*;

public class ListExample {

    public static void main(String[] args) {
        /**
         List<Integer> list1 = new ArrayList<>();
         ・<>안에 타입 명시하는데 리스트와 같은 제네릭 타입들은 원시자료형들을 허용하지 않기때문에 Integer라는 wrapper타입을 사용해야한다.
         ・List는 모양새만을 정의한 껍데기같은것이기 때문에 직접 생성해서 사용할 수 없다.
         ・그래서 List의 모양을 그대로 따르는 ArrayList라는것을 사용한다.
         ・List가 부모이고 ArrayList는 자식관계. 자식들은 더 있지만 현재 강의에서는 ArrayList만 쓰기로한다.
         ・List는 중복값을 허용한다.
         ・아래의 list2, list3 모두 list1과 동일하다
         List<Integer> list2 = new ArrayList<Integer>();
         ArrayList<Integer> list3 = new ArrayList<>();
         */

        //List가 배열보다 편한 이유는 요소들을 마음대로 추가, 제거 할수 있고, 여러가지 메소드를 제공한다
        List<String> list = new ArrayList<>();
        list.add("치킨");
        list.add("피자");
        list.add("치킨");
        //list의 메소드중에서 add를 이용하면 리스트에 요소를 추가할 수 있다. 위에서 String으로 정의했기때문에 문자열을넣는다.
        System.out.println(list);

        //list.remove("치킨");
        //list.remove(0);
        //List의 메소드중에서 remove를 이용하면 리스트에 요소를 제거할 수 있다. 방법은 해당 문자열을 직접 지정하거나 인덱스를 직접 지정
        System.out.println(list);

        list.set(0,"치킨");
        //List의 메소드중에서 set를 이용하면 리스트에 요소를 변경할 수 있다. 첫번째인자는 인덱스 번호, 두번째 인자는 값
        System.out.println(list);

        String food01 = list.get(0);
        System.out.println(list.get(0));
        //List에서 요소 하나만 가저다 쓰고싶을땐 get이라는 메소드를 사용한다. get의 인자로는 인덱스를 넣어준다.

        boolean containsChicken = list.contains("치킨");
        System.out.println(containsChicken);
        //List에 포함된 contains 라는 메소드를 사용해 중복값을 찾아낼 수 있다.

        System.out.println("저장할 음식 이름 입력. (종료: 0)");
        List<String> foods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            String food = scanner.nextLine();

            if (food.equals("0")){
                break;
            }

            if (foods.contains(food)){
                System.out.println("이미 목록에 있습니다.");
            } else {
                foods.add(food);
            }
        }

        Collections.sort(foods);
        //리스트를 정렬하는 메소드 sort는 오름차순으로 정렬한다
        Collections.reverse(foods);
        //reverse는 오름차순으로 된 리스트를 reverse를 사용해 역순으로 정렬할 수 있다.
        Collections.shuffle(foods);
        //shuffle은 리스트의 목록을 랜덤한 순서로 정렬할 수 있따.

        System.out.println(foods);
    }


}
