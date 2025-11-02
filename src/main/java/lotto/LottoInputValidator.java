package lotto;

import java.util.List;

public class LottoInputValidator {
    public static void validateDivision(int number) {
        if(number % 1000 == 0) return;
        throw new IllegalArgumentException();
    }

    public static void validateNumberRange(List<Integer> numbers) {
        boolean hasOutOfRangeNumber = numbers.stream()
                .anyMatch(number -> number > 45 || number < 1);
        if(hasOutOfRangeNumber) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
