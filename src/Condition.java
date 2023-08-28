import java.util.Scanner;

public class Condition {
    public static void main(String[] args) {

        //조건문
        //현재 가진돈으로 음식을 먹을수있는지 출력해보자
        int money = 500; //가진돈에 따라서 밑의 조건문중에 한개의 조건을만족시켜 출력할 수 있다
        if (money >= 8000) {
            System.out.println("순대국 맛있다");
        } else if (money >= 5000) { // if와 else 사이에 조건을 추가한다.  참, 거짓이외의 조건도 추가할수있다
            System.out.println("삼각김밥 맛있다");
        } else {
            System.out.println("흑흑흑, 배고프다");
        }

        //if문의 중첩
        int age = 25;
        if (age >= 10){
            if (age < 20){
                System.out.println("10대");
            }else {
                System.out.println("10대 아님");
            }
        } else {
            System.out.println("10대 아님");
        }

        //중첩된 if문은 구조가 복잡해 보일 수 있으므로 하나의 if문 안에 여러 조건을 명시 할 수 있다. 두 조건 모두를 만족시키는경우 &&
        if (age >= 10 && age < 20){
            System.out.println("10대");
        } else {
            System.out.println("10대 아님");
        }

        //두 조건중 한개의 조건만 만족시켜도 true를 반환하는 경우
        if (age < 10 || age >= 20){
            System.out.println("10대 아님");
        } else {
            System.out.println("10대");
        }

        //switch - case , break를 써주지않으면 break가 나올때까지 모든 구문이 실행된다
        int month = 9;
        switch (month){
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 5:
                System.out.println("May");
                break;
            default:
                System.out.println("일치하는 값 없음");
        }


        //문자열 비교하기
        String a = "치킨";
        Scanner scanner = new Scanner(System.in); // scanner = 터미널? 에서 문자를 입력받을 수 있음
        String b = scanner.nextLine();

        System.out.println(a == b); // 치킨이라는 문자를 입력해도 false가 출력됨
        System.out.println(a.equals(b)); // 치킨이라는 문자를 입력하면 true 출력됨. 문자열을 비교할때는 equals를 쓴다.


        //음식이름을 입력하면 가격을 알려주는 코드
        System.out.println("음식 이름을 입력하세요.");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();

        switch (name) {
            case "치킨":
                System.out.println("치킨은 500원입니다.");
                break;
            case "순대국":
                System.out.println("순대국은 8천원입니다.");
                break;
            case "스테이크":
                System.out.println("스테이크는 5천원입니다.");
                break;
            default:
                System.out.println("메뉴에 존재하지 않는 음식입니다.");
        }

        //문제1. 양계장에서 닭이 낳은 달걀의 수에 따라 포장에 필요한 계란판의 수를 계산하는 프로그램을
        //의뢰했다. 달걀 30개당 하나의 계란판이 필요하다고 할 때 계란판이 필요하지 않은 경우에는
        //"계란판이 필요하지 않습니다" 라는 문구를 출력하고 필요한 경우에는 "총 x개의 계란판이 필요합니다"
        //라는 문구를 출력해주는 프로그램을 만들어라
        int egg = 270;

        if(egg < 30){
            System.out.println("계란판이 필요하지 않습니다.");
        } else {
            System.out.println("총"+egg/30+"개의 계란판이 필요합니다.");
        }

        //문제2. 비만 계산방법은 BMI지수 = 몸무게(Kg) / (신장(m) x 신장(m))입니다. BMI를 계산해 저체중인지
        //과체중인지 정상 체중인지를 출력해주는 프로그램을 만드세요. BMI가 18.5 미만은 저체중 23 이상이면 과체중입니다.
        double kg = 82;
        double tall = 1.82;
        double bmi = kg/(tall*tall);
        System.out.println(bmi);
        if(bmi > 23){
            System.out.println("과체중입니다.");
        } else if (bmi < 18.5) {
            System.out.println("저체중입니다.");
        }else {
            System.out.println("정상체중입니다.");
        }
    }
}
