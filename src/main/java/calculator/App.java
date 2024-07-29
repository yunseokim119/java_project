package calculator;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 요구사항 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.

        Calculator calculator = new Calculator();
        // Level2의 두 번쩨 요구사항

        List<Integer> results = calculator.getResults();

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

            try {
                // Calculator 객체를 사용하여 계산 수행
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과 : " + result);
            } catch (OneException e) {
                System.out.println("잘못된 연산입니다 : " + e.getMessage());
                continue;
            }

            System.out.println("remove 입력 시 가장 먼저 저장된 결과 삭제");
            System.out.println("inquiry 입력 시 모든 결과 조회");
            System.out.println("exit 입력 시 종료");
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
                results = calculator.getResults();
                System.out.println("저장된 모든 결과:");
                for (int i = 0; i < results.size(); i++) {
                    System.out.println("결과 " + (i + 1) + ": " + results.get(i));
                }
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
        sc.close();
    }
}