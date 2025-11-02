package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int lottoPrice = 1000;

    public static List<Lotto> purchaseLottos(int purchaseMoney) {
        List<Lotto> lottos = purchaseLotto(purchaseMoney);
        return lottos;
    }

    private static List<Lotto> purchaseLotto(int purchaseMoney) {
        int purchaseLottoCount = purchaseMoney / lottoPrice;
        System.out.println(purchaseLottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseLottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = Lotto.purchase(lottoNumbers);
            lotto.printNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }

    public static void printResult(List<Lotto> lottos, List<Integer> successNumbers, int bonusNumber) {
        Map<LottoResult, Integer> lottoWinningNumbers = winning(lottos, successNumbers, bonusNumber);

        System.out.println("담청 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + lottoWinningNumbers.getOrDefault(LottoResult.THREE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoWinningNumbers.getOrDefault(LottoResult.FOUR, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoWinningNumbers.getOrDefault(LottoResult.FIVE, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningNumbers.getOrDefault(LottoResult.FIVE_AND_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinningNumbers.getOrDefault(LottoResult.SIX, 0) + "개");

        int revenue = calcurateRevenue(lottoWinningNumbers);
        double revenueRate = ((double) revenue / (lottos.size() * 1000)) * 100;
        System.out.println("총 수익률은 " + String.format("%.2f", revenueRate) + "%입니다.");
    }

    private static int calcurateRevenue(Map<LottoResult, Integer> lottoWinningNumbers) {
        return lottoWinningNumbers.entrySet()
                .stream()
                .map(result -> {
                        LottoResult lottoResult = (LottoResult) result.getKey();
                        int price = lottoResult.getPrice() * result.getValue();
                        return price;
                    }
                )
                .reduce(0, Integer::sum);

    }

    public static Map<LottoResult, Integer> winning(List<Lotto> lottos, List<Integer> successNumbers, int bonusNumber) {
        Map<LottoResult, Integer> winning = lottos.stream()
                .map(lotto -> lotto.winning(successNumbers, bonusNumber))
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                result -> 1,
                                Integer::sum
                        )
                );
        return winning;
    }
}
