public class Operator {
    public static void main(String[] args) {
        //기본적인 연산
        System.out.println(2 + 3);
        System.out.println(5 - 2);
        System.out.println(2 * 3);
        System.out.println(6 / 3);
        System.out.println(7 % 3); // %는 나눈 후의 나머지 값을 구하는 연산자이다

        //나눗셈시의 주의점
        System.out.println(7 / 2); // 정수/정수의 연산은 정수가 된다(소수점 이하는 버려짐)

        //연산의 우선순위
        // 괄호안의 연산을 우선 수행,   *,/,% 좌측 순으로 수행,   +,- 좌측 순으로 수행
        System.out.println((2 - 4) / 2);


        int number = 5;
        // number = 1.2; 정수타입으로 정의된 수에 실수를 넣으면 오류뜸
        number = (int) 1.2; // 정수타입의 변수에 실수를 넣었지만 정수로 형변환을 해주면 오류가 뜨지않는다. 하지만 소수점 아래수는 버려짐

        //정수와 실수의 연산
        System.out.println(1 + 1.2); //정수 + 실수의 결과는 실수 출력
        System.out.println(7 / 2); //정수 / 정수의 결과는 정수 출력
        System.out.println(7 / 2.0); //정수 / 실수의 결과는 실수 출력

        //비교연산자
        System.out.println(2 < 3);
        System.out.println(2 <= 3);
        System.out.println(2 > 3);
        System.out.println(3 >= 3);
        System.out.println(5 == 3);
        System.out.println(5 == 5);
        System.out.println(5 != 5);
        System.out.println(3 != 5);

        //문제. 양계장에서 닭이 낳은 알이 277개 있다. 한 판에 30개의 알이 포장된다고 할 때 포장된 계란판의 수와 남은 알의 수를 출력하시오
        int egg;
        int rappingEgg;
        egg = 277;
        rappingEgg = 30;

        System.out.println("포장된 계란" + egg/rappingEgg + "판");
        System.out.println("남은 계란" + egg%rappingEgg + "개");
    }
}
