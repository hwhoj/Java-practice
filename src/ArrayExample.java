import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {

        //배열이란? 변수 하나에 여러개의 값을 담을 수 있는 자료
        //변수의 자료형 뒤에[]가 달리면 이자료형에 배열을 사용하겠다는 뜻
        String[] days = {"월", "화", "수", "목", "금", "토", "일"};


        //배열의 순서를 입력해 해당위치의 변수를 불러올수있다
        //System.out.println(days[0]);
        //System.out.println(days[6]);


        //배열의 길이 알아내기. 변수명.length
        int legnthOfDays = days.length;
        System.out.println(legnthOfDays); //월화수목금토일 7개이니까 7이 출력된다


        //배열에 반복문 사용하기. 간소화된코드로 모든 요일을 출력할수 있다.
        for (int i = 0; i < days.length; i = i + 1){ //i < days.length 의미 (7보다 작을때까지)
            System.out.println(days[i] + "요일");
        }


        //배열의 특정 요소 바꾸기
        //days[0] = "일"; //해당 순서의 값을 변경시킬수 있다


        //세련된 반복문 for(type(자료형) element(반복문 안에서 현재 요소를 지칭할 이름) : array(반복문을 적용할 배열))
        for(String day : days){
            System.out.println(day + "요일");
        }


        //배열의 추가
        String[] days2 = Arrays.copyOf(days, 8);
        //copyOf() 메소드는 배열을 복사할수 있다. ()안에는 복제하기를 원하는 배열을 입력하고 그 뒤에는 배열의 길이를 입력
        //days 는 7개의 배열이지만 days2는 8을 입력했으므로 8개의 배열을 가질 수 있게된다

        days2[7] = "일";
        for (String day : days2){
            System.out.println(day + "요일");
        }


        //toString() 기능으로 배열의 내용 출력
        System.out.println(days);
        System.out.println(Arrays.toString(days));


        //2차원 배열
        String[][] days3 = {
                {"월", "화", "수", "목", "금", "토", "일"},
                {"월", "화", "수", "목", "금", "토", "일"},
                {"월", "화", "수", "목", "금", "토", "일"}
        };

        System.out.println(Arrays.toString(days3[0]));
        System.out.println(Arrays.toString(days3[1]));
        System.out.println(Arrays.toString(days3[2]));
    }
}
