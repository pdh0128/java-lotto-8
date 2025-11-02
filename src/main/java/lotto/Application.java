package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final List<Integer> successNumbers = List.of(1,2,3,4,5,6);
    private static final int bonusNumber = 7;

    public static void main(String[] args) {
        int lottoPurchaseMoney = Integer.parseInt(Console.readLine()); // 로또 구입 금액
        LottoInputValidator.validateDivision(lottoPurchaseMoney);
        List<Lotto> lottos = LottoMachine.purchaseLottos(lottoPurchaseMoney);

        int rateOfReturn = LottoMachine.printResult(lottos, successNumbers, bonusNumber);

    }
}
