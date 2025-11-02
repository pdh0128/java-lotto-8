package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int lottoPurchaseMoney = Integer.parseInt(Console.readLine()); // 로또 구입 금액
        LottoInputValidator.validateDivision(lottoPurchaseMoney);

    }
}
