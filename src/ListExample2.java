import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample2 {
    public static void main(String[] args) {
        /**
        List<String> names = new ArrayList<>();
        names.add("정동원");
        names.add("장민호");
        names.add("임영웅");
        names.add("이찬원");
        일일히 이름을 추가하는것은 코드가 복잡해질 수 있다.

        */

        //목록을 편하게 넣는방법중 배열을 리스트로 만드는 방법이 있다. Arrays.asList
        List<String> names = Arrays.asList("정동원", "장민호", "임영웅", "이찬원");
        System.out.println(names);
    }
}
