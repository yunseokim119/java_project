package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 요구사항 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.

        ArrayList<Integer> results = new ArrayList<>();

        Calculator calculator = new Calculator();

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

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                case '%':
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다.");
                    continue;
            }

            results.add(result);
            System.out.println("결과: " + result);

            //요구사항 7. “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현합니다.
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            //요구사항 8. “inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
            System.out.println("inquiry 입력 시 모든 결과 조회");

            //요구사항 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.next();
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input.equals("remove")) {
                if (!results.isEmpty()) {
                    results.remove(0);
                    System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
            } else if (input.equals("inquiry")) {
                System.out.println("저장된 모든 결과:");
                for (int i = 0; i < results.size(); i++) {
                    System.out.println("결과 " + (i + 1) + ": " + results.get(i));
                }
            }
        }
        sc.close();
    }
}