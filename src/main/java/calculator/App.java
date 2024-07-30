package calculator;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        // 레벨2-7 Calculator 인스턴스를 만들지 않고 바로 Calculator 클래스의 static 메서드를 사용하도록 수정
        Calculator calculator = new Calculator();
        // 레벨2-2

        while (true) {

            System.out.println("calc: 사칙연산");
            System.out.println("circle: 원의 넓이 계산");
            System.out.println("exit: 프로그램 종료");
            System.out.println("명령어를 입력하세요");
            final String command = sc.next();
            // 아래에 String input = sc.next();가 있으므로 input 사용시 오류발생

            if (command.equals("calc")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                final int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                final int num2 = sc.nextInt();

                // 요구사항 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
                System.out.print("사칙연산 기호를 입력하세요: ");
                final char operator = sc.next().charAt(0);
                /* charAt(idx) : charAt 메소드는 매개변수로 char 타입으로 변환 하고자하는 문자열의 위치(index)를 받는다. */

                try {
                    // Calculator 객체를 사용하여 계산 수행
                    final int result = calculator.calculate(num1, num2, operator);
                    System.out.println("결과 : " + result);
                } catch (OneException e) {
                    System.out.println("잘못된 연산입니다 : " + e.getMessage());
                    continue;
                }
            } else if (command.equals("circle")) {
                System.out.print("반지름을 입력하세요: ");
                final double radius = sc.nextDouble();

                final double area = calculator.calculateCircleArea(radius);
                System.out.println("원의 넓이: " + area);
            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("유효하지 않은 입력입니다.");
                continue;
            }

            System.out.println("removeCalc 입력 시 가장 먼저 저장된 사칙연산 결과 삭제");
            System.out.println("removeCircle 입력 시 가장 먼저 저장된 원의 넓이 결과 삭제");
            System.out.println("inquiryCalc 입력 시 모든 사칙연산 결과 조회");
            System.out.println("inquiryCircle 입력 시 모든 원의 넓이 결과 조회");
            System.out.println("계속 진행하려면 아무 키나 누르세요.");
            final String input = sc.next();

            if (input.equals("removeCalc")) {
                calculator.removeFirstArithmeticResult();
                System.out.println("가장 먼저 저장된 사칙연산 결과가 삭제되었습니다.");
            } else if (input.equals("removeCircle")) {
                calculator.removeFirstCircleAreaResult();
                System.out.println("가장 먼저 저장된 원의 넓이 결과가 삭제되었습니다.");
            } else if (input.equals("inquiryCalc")) {
                List<Number> results = calculator.getArithmeticResults();
                System.out.println("저장된 모든 사칙연산 결과:");
                if (results.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println("결과 " + (i + 1) + ": " + results.get(i));
                    }
                }
            } else if (input.equals("inquiryCircle")) {
                List<Double> results = calculator.getCircleAreaResults();
                System.out.println("저장된 모든 원의 넓이 결과:");
                if (results.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println("결과 " + (i + 1) + ": " + results.get(i));
                    }
                }
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
        sc.close();
    }
}