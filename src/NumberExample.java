public class NumberExample {
    public static void main(String[] args) {
        //숫자 1 과 "1"은 다르다
        System.out.println(37);

        //'A'는 문자 "A"는 문자열이다
        System.out.println("나는 문자열");
        //System.out.println('나는 문자'); 문자열은 ""로 묶어야된다

        //"" 안에 ""를 사용하고싶을떄 백슬레시를 사용한다
        System.out.println("안녕 나는\"자바\"야.");

        //\n을 입력하면 한문장을 두줄로 출력할수 있다
        System.out.println("치킨은 살 안 쪄요. \n살은 내가 쪄요.");

        //문제1. 길동이의 생일은 6월 16일이다. 길동이의 생일을 출력하시오(출력 형식 x월 xx일)
        System.out.println("6월 16일");

        //문제2. 길동이가 태어난 달과 날짜를 더한 결과를 출력하시오
        System.out.println(6 + 16);

    }
}
