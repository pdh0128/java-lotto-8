package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = List.copyOf(Set.copyOf(numbers));
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto purchase(List<Integer> numbers) {
        LottoInputValidator.validateNumberRange(numbers);
        Lotto lotto = new Lotto(numbers);
        lotto.validate(numbers);
        lotto.sortNumbersOrderByAsc(numbers);
        return lotto;
    }

    private void sortNumbersOrderByAsc(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        this.numbers = sorted;
    }

    public void printNumbers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<String> numberTexts = this.numbers.stream()
                .map(String::valueOf)
                .toList();
        sb.append(String.join(", ", numberTexts));
        sb.append("]");
        System.out.println(sb);
    }

    public LottoResult winning(List<Integer> successNumbers, int bonusNumber) {
        return LottoResult.winning(this.numbers, successNumbers, bonusNumber);
    }

    // TODO: 추가 기능 구현
}
