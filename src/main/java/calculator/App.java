package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        System.out.printf("operator = " + operator);
        // 요구사항 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
    }
}