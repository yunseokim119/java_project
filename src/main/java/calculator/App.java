package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 요구사항 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.

        int[] results = new int[10];
        int resultCount = 0;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int num2 = sc.nextInt();

            // 요구사항 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            /* charAt(idx) : charAt 메소드는 매개변수로 char 타입으로 변환 하고자하는 문자열의 위치(index)를 받는다. */
            // System.out.printf("operator = " + operator);

            //요구사항 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
            int result = 0;
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

            if (resultCount < results.length) {
                results[resultCount] = result;
                resultCount++;
                System.out.println("결과: " + result);
            } else {
                System.out.println("결과 저장 공간이 부족합니다. 프로그램을 종료합니다.");
                break;
            }

            System.out.println("현재까지의 결과:");
            for (int i = 0; i < resultCount; i++) {
                System.out.println("결과 " + (i + 1) + ": " + results[i]);
            }

            //요구사항 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit") == true) { // 문자열을 비교할 때 등가비교연산자 == 이 아닌 .equals()메소드를 사용
                System.exit(0);
            }
            /* exit을 입력 받으면 반복 종료 */
        }
        sc.close();
    }
}