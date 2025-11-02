package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int lottoPurchaseMoney = Integer.parseInt(Console.readLine()); // 로또 구입 금액
        LottoInputValidator.validateDivision(lottoPurchaseMoney);
        List<Lotto> lottos = LottoMachine.purchaseLottos(lottoPurchaseMoney);

        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> successNumbers = Spliter.split(Console.readLine());

        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println();

        LottoMachine.printResult(lottos, successNumbers, bonusNumber);

    }
}
