package pl.campaignapplication.exceptionMethod;

import pl.campaignapplication.exception.NegativeBalnceException;

public class IsBalanceGood {
    public static void check(int balance) throws NegativeBalnceException {
        if(balance<0){
            throw new NegativeBalnceException();
        }
    }
}
