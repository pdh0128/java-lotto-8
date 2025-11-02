package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int lottoPrice = 1000;

    private final List<Integer> successNumbers;
    private final int bonusNumber;

    public LottoMachine(List<Integer> successNumbers, int bonusNumber) {
        this.successNumbers = successNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void execute(int purchaseMoney) {
        List<Lotto> lottos = purchaseLotto(purchaseMoney);
    }

    private List<Lotto> purchaseLotto(int purchaseMoney) {
        int purchaseLottoCount = purchaseMoney / lottoPrice;
        System.out.println(purchaseLottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseLottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return  lottos;
    }
}
