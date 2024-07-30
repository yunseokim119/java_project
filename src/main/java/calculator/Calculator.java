package calculator;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public abstract class Calculator<T> {
    // 결과를 저장하는 필드
    private final List<T> results;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 결과를 추가하는 메서드
    protected void addResult(T result) {
        results.add(result);
    }

    // 결과의 불변 사본을 반환하는 메서드
    public List<T> getResults() {
        return Collections.unmodifiableList(results);
    }

    // 가장 먼저 저장된 결과를 삭제하는 메서드
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}