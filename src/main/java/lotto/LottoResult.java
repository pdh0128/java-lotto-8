package lotto;

import java.util.List;

public enum LottoResult {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_AND_BONUS(30000000),
    SIX(2000000000),
    FAIL(0);

    private final int price;

    LottoResult(int price) {
        this.price = price;
    }

    public static LottoResult winning(List<Integer> numbers, List<Integer> successNumbers, int bonusNumber) {
        int count = (int) numbers.stream()
                .filter(successNumbers::contains)
                .count();
        boolean winningBonusNumber = numbers.contains(bonusNumber);

        return LottoResult.fromCount(count, winningBonusNumber);
    }

    private static LottoResult fromCount(int count, boolean winningBonusNumber) {
        if(count == 3) return THREE;
        if(count == 4) return FOUR;
        if(count == 5 && winningBonusNumber) return FIVE_AND_BONUS;
        if(count == 5) return FIVE;
        if(count == 6) return SIX;

        return LottoResult.FAIL;
    }
}
