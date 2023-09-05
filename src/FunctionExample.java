public class FunctionExample {
    public static void main(String[] args) {
        sayHello();
        sayHelloTo("chicken");
        printSum(3, 5);
        int result = sum(2,4); //sum이라는 메소드가 값을 반환하기때문에 그 값을 변수로 받는다.
        System.out.println(result);

        //배열을 사용하는 방법은 순서대로 어떤값이 들어가있는지 미리 알고있어야하므로 잘 사용되지는 않는다.
        int[] sumAndProduct = addAndMultiply(2, 3);
        System.out.println("sum: " + sumAndProduct[0]);
        System.out.println("product: " + sumAndProduct[1] );

        sayHola("바보");
    }

    //메소드는 코드를 중괄호로 감싸고 이름을 붙여놓은것이다
    public static void sayHello(){
        System.out.println("Hello");
    }
    
    //입력값이 존재하는 메소드
    public static void sayHelloTo(String name){
        System.out.println("Hello," + name);
    }

    //메소드의 인자(매개변수)는 여러개가 될 수도있다.
    public static void printSum(int a, int b){
        System.out.println(a + " + " + b + " = " + (a + b));
    }//a+b=c의 형태로 덧셈을 출력하는 메소드

    /*
    메소드 안에 메소드를 넣어서도 가능
    public static void printSum(int a, int b){
        System.out.println(a + " + " + b + " = " + sum(a+b));
    }
    */

    //두 정수를 더한 값을 반환한다.
    public static int sum(int a, int b){ //반환 타입이 정수이기때문에 void가 아닌 int
        return a + b; //메소드에서 값을 반환하려면 return이라는 키워드를 사용함. return뒤에 사용하는값이 메소드의 반환값이된다.
    }

    //두 정수를 더한 값과 곱한 값을 반환한다.
    public static int[] addAndMultiply(int a, int b){
        int sum = a + b;
        int product = a * b;

        int[] result = {sum, product};

        return result;
    }

    public static void sayHola(String name){
        if (name.equals("바보")){
            System.out.println("바르고 고운 말을 사용해주세요");
        } else {
            System.out.println(name + "님, 안녕하세요?");
        }
        /**
        if (name.equals("바보")){
            System.out.println("바르고 고운 말을 사용해주세요");
            return; //리턴을 사용하면 아래의 코드를 거치지 않고빠져나간다.
         //하지만 return의 타입이 요구하는 자료형과 맞춰야한다.
        }
         System.out.println(name + "님, 안녕하세요?");

        */

    }
}
