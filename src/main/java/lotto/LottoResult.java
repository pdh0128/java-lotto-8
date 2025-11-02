package lotto;

public enum LottoResult {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_AND_BONUS(30000000),
    SIX(2000000000)
    ;

    private final int price;

    LottoResult(int price) {
        this.price = price;
    }
}
