package pl.campaignapplication.exceptionMethod;

import pl.campaignapplication.exception.ValueUnderZeroException;

public class IsValuePositive {
    public static void check(int value) throws ValueUnderZeroException {
        if (value < 0) {
            throw new ValueUnderZeroException();
        }
    }
}
