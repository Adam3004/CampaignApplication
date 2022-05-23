package pl.campaignapplication.tools;

import pl.campaignapplication.exception.NegativeBalnceException;
import pl.campaignapplication.exception.ValueUnderZeroException;
import pl.campaignapplication.exceptionMethod.IsBalanceGood;
import pl.campaignapplication.exceptionMethod.IsValuePositive;

public class IsCampaignCorrect {
    public static boolean checkNumbers(int currentBalance, int radius, int bidAmount) {
        try {
            IsBalanceGood.check(currentBalance);
            IsValuePositive.check(radius);
            IsValuePositive.check(bidAmount);
        } catch (NegativeBalnceException | ValueUnderZeroException e) {
            e.getLocalizedMessage();
            return false;
        }
        return true;
    }
}
