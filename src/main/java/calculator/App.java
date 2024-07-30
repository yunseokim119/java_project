package calculator;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {
            System.out.println("명령어를 입력하세요:");
            System.out.println("calc: 사칙연산");
            System.out.println("circle: 원의 넓이 계산");
            System.out.println("exit: 프로그램 종료");
            final String command = sc.next();

            if (command.equals("calc")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                final int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                final int num2 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                final char operator = sc.next().charAt(0);

                try {
                    final int result = arithmeticCalculator.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                } catch (OneException e) {
                    System.out.println("잘못된 연산입니다: " + e.getMessage());
                    continue;
                }
            } else if (command.equals("circle")) {
                System.out.print("반지름을 입력하세요: ");
                final double radius = sc.nextDouble();

                final double area = circleCalculator.calculateArea(radius);
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
                arithmeticCalculator.removeFirstResult();
                System.out.println("가장 먼저 저장된 사칙연산 결과가 삭제되었습니다.");
            } else if (input.equals("removeCircle")) {
                circleCalculator.removeFirstResult();
                System.out.println("가장 먼저 저장된 원의 넓이 결과가 삭제되었습니다.");
            } else if (input.equals("inquiryCalc")) {
                List<Integer> results = arithmeticCalculator.getResults();
                System.out.println("저장된 모든 사칙연산 결과:");
                if (results.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println("결과 " + (i + 1) + ": " + results.get(i));
                    }
                }
            } else if (input.equals("inquiryCircle")) {
                List<Double> results = circleCalculator.getResults();
                System.out.println("저장된 모든 원의 넓이 결과:");
                if (results.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println("결과 " + (i + 1) + ": " + results.get(i));
                    }
                }
            }
        }
        sc.close();
    }
}
