package lotto;

public class LottoInputValidator {
    public static void validateDivision(int number) {
        if(number % 1000 == 0) return;
        throw new IllegalArgumentException();
    }
}
