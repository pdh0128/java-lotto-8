package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
            Lotto lotto = new Lotto(lottoNumbers);
            lotto.printNumbers();
            lottos.add(lotto);
        }
        return  lottos;
    }

    public static int printResult(List<Lotto> lottos, List<Integer> successNumbers, int bonusNumber) {
        System.out.println("담청 통계");
        System.out.println("---");

        return 0;
    }
}
