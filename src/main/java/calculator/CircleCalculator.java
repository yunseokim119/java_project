package calculator;

public class CircleCalculator extends Calculator<Double> {

    // 반지름을 매개변수로 받아 원의 넓이를 계산하여 반환하는 메서드
    public double calculateArea(double radius) {
        double area = Math.PI * radius * radius;

        // 원의 넓이 결과를 리스트에 추가
        addResult(area);

        return area;
    }
}
