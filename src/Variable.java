public class Variable {
    public static void main(String[] args) {
        //변수란? 값을 가질 수 있는 특별한 이름. 값은 변할 수 있지만 이름은 변하지 않는다.
        int number;
        number = 3;
        number = 10;

        System.out.println(number);

        /**
         * 한 마트에서 물건을 구매하면 15%의 적립금을 추가로 적립해준다고 한다. 이 마트가 다음과 같은
         * 구매금액별 적립금을 계산해 주는 프로그램을 의뢰했다.
         * 100원, 300원, 1000원, 10000원
        */
        System.out.println(100 * 0.15);
        System.out.println(300 * 0.15);
        System.out.println(1000 * 0.15);
        System.out.println(10000 * 0.15);

        //위의 문제에서 적립금의 변동이 있을때 많은 양의 데이터를 수정하기 힘드므로 변수를 사용하는것이 편리하다
        int ratio = 15;
        System.out.println(100 * ratio / 100.0);
        System.out.println(300 * ratio / 100.0);
        System.out.println(1000 * ratio / 100.0);
        System.out.println(10000 * ratio / 100.0);



        /**좋은 변수명과 나쁜 변수명
         * 위의 a,b 변수명은 무엇을 나타내는지 알수가 없지만 아래의 변수명은 10년후의 나이를 출력해주는
         * 코드라는 것을 알 수 있다.
         * 첫 글자는 반드시 영문 대소문자나 언더스코어(_), 또는 $여야 하지만 영문 소문자로 시작하는것이 권장됨
         * ex) int _age(x) // int Age(x) // int age(O)
         * 첫 글자를 제외한 나머지 글자에는 영문 대소문자, 언더스코어, $, 숫자를 사용할 수 있다.
         * ex) int page_number(x) // int pageNumber (O)
         * 영문은 대소문자를 구문한다. age와 aGe는 다른 변수이다.
         * 자바에서 변수명의 시작은 소문자로, 그 뒤부터는 단어 단위로 첫 글자만 대문자를 사용하는 카멜케이스 표기법이 권장된다.
         */
        int a = 17;
        int b = a + 10;

        int age = 17;
        int ageAfter10Years = age + 10;


        //문제1. 길동이의 현재 나이는 8세이다. 현재 길동이의 나이와 10년 후, 20년 후, 30년 후 나이를 출력하시오
        int ageOfGildong = 8;
        System.out.println(ageOfGildong);
        System.out.println(ageOfGildong + 10);
        System.out.println(ageOfGildong + 20);
        System.out.println(ageOfGildong + 30);

        //문제2 시간이 흘러 길동이의 나이가 9세가 되었다. 앞서 작성한 코드를 수정해 나이가 9세일때 10년 후, 20년 후, 30년 후 나이를 출력하시오
        ageOfGildong = 9;
        System.out.println(ageOfGildong);
        System.out.println(ageOfGildong + 10);
        System.out.println(ageOfGildong + 20);
        System.out.println(ageOfGildong + 30);
    }
}
