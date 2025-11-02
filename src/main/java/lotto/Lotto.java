package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public Lotto purchase(List<Integer> numbers) {
        validate(numbers);
        sortNumbersOrderByAsc(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private void sortNumbersOrderByAsc(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public void printNumbers() {
        for(Integer number : numbers) {
            System.out.println(number);
        }
    }

    // TODO: 추가 기능 구현
}
