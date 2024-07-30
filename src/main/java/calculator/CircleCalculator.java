package calculator;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CircleCalculator extends Calculator<Double> {

    private static final double PI = Math.PI;

    // 생성자
    public CircleCalculator() {
        super();
    }

    // 원의 넓이를 계산하는 메서드
    public double calculateArea(double radius) {
        double area = PI * radius * radius;
        // 연산 결과를 리스트에 추가
        addResult(area);
        return area;
    }
}
