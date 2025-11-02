package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int lottoPurchaseMoney = inputLottoPurchaseMoney();

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

    private static int inputLottoPurchaseMoney() {
        int lottoPurchaseMoney;
        while (true) {
            try {
                lottoPurchaseMoney = Integer.parseInt(Console.readLine());
                LottoInputValidator.validateDivision(lottoPurchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야합니다.");
            }
        }
        return lottoPurchaseMoney;
    }
}
