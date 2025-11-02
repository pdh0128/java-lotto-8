package lotto;

public class LottoInputValidator {
    public static void validateDivision(int number) {
        if(number % 1000 == 0) return;
        System.out.println("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야합니다.");
        throw new IllegalArgumentException();
    }
}
