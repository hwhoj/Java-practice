public class DataForm {
    public static void main(String[] args) {
        byte byteInteger = 10; //데이터 크기 1byte, -128 ~ 127
        short shortInteger = 20; //데이터 크기 2byte, -32,768 ~ 32767
        int intInteger = 30; //데이터 크기 4byte, -2,147,483,648 ~ 2,147,483,647
        long longInteger = 40; //데이터 크기 8byte, -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

        //연산에서 long 이외의 연산의 결과는 항상 int형이된다
        //short sum = byteInteger + shortInteger; 위의 이유로 short형 선언하면 오류남
        int sum = byteInteger + shortInteger;
        int sum2 = shortInteger + intInteger;
        //int sum3 = intInteger + longInteger; X //long 타입의 연산은 long 타입 선언이 필요하다
        long sum3 = intInteger + longInteger;
        //int sum4 = byteInteger + longInteger; X //long 타입의 연산은 long 타입 선언이 필요하다


        //실수형
        //float 데이터 크기 4byte, double 데이터 크기 8byte
        //float floatNumber = 1.2; float 형에서 소수점이 포함된 숫자를 썼을때 기본적 double형으로 인식하기 때문에 오류가난다
        float floatNumber = 1.2f; // 숫자 뒤에 f를 붙여주면 오류 안남
        double doubleNumber = 4.3;

        float floatSum = 0.001f + 0.001f + 0.0001f;
        System.out.println(floatSum);
        //출력하면 틀린 계산이 나오는데 자바는 실수계산이 정확하지않다.
        //그래서 정확한 연산이 필요한 은행같은 경우에 자바를 사용할 경우 정수형 연산을 사용한다.
        //ex 정수타입으로 계산한 후 나눗셈을 통해 소숫점으로 바꿔줌


        //문자형 char 데이터 크기 2byte


        //문자열 String
        String chicken = "치킨은 살 안쪄요.";
        String me = "살은 내가 쪄요.";

        //문자열 연결하기
        System.out.println(chicken+me);//출력문에 +를 사용해도되고
        //문자열 변수 선언에서도 + 를 사용할 수 있다.
        String chickenAndMe = chicken + me;
        System.out.println(chickenAndMe);

        //문자열의 글자 수 세기 stringName.length()
        System.out.println(me.length()); //공백도 1글자 취급되서 9가 출력됨
        //문자열의 길이 length()는 정수형으로 반환 할 수 있기 때문에 정수형 변수를 선언할 수 있다.
        int length = me.length();
        System.out.println(length);

        //문자열 바꾸기 stringName.replaceAll("바꿀 문자열", "새 문자열")
        //System.out.println(me.replaceAll("내가", "치킨이"));
        //문자열 바꾸기 replaceAll()은 문자형으로 반환 할 수 있기 때문에 문자열 변수를 선언할 수 있다.
        String replaced = me.replaceAll("내가", "치킨이");
        System.out.println(replaced);

        //문자열 자르기 stringName.substring(0, 4) 0=시작위치, 4끝위치(끝위치는 안잘림)
        String birthday = "1990/04/02";
        //사용법1 시작위치와 끝위치를 지정하는방법
        String year = birthday.substring(0,4);
        //사용법2 시작위치만 지정하는 방법, 시작위치 전의 문자열이 잘림
        String day = birthday.substring(8);
        System.out.println(year);
        System.out.println(day);


        //논리형 boolean. true, false로만 표현됨
        boolean trueValue = true;
        boolean falseValue = false;
        boolean question = 5 > 3;


        //wrapper 타입
        Integer integerNumber = 3;
        float floatNumber2 = integerNumber.floatValue(); //3.0f
        double doubleNumber2 = integerNumber.doubleValue(); //3.0d
        String stringNumber2 = integerNumber.toString(); // "3"

    }
}
