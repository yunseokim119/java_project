package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /* Scanner sc = new Scanner(System.in);


        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num2 = sc.nextInt();
        // 요구사항 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);
        /* charAt(idx) : charAt 메소드는 매개변수로 char 타입으로 변환 하고자하는 문자열의 위치(index)를 받는다. */
        // System.out.printf("operator = " + operator);
        // 요구사항 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다. */


        //3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
        //    - 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
        //    - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (e.g.if, switch)
        //    - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
        //        - e.g. “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);
        int result = 0;
        /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            result = num1 / num2;
        } else if (operator == '%') {
            result = num1 % num2;
        }


        System.out.println("결과: " + result);
    }
}