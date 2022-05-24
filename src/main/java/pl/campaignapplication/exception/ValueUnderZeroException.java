package pl.campaignapplication.exception;

public class ValueUnderZeroException extends Exception {
    public ValueUnderZeroException() {
        System.out.println("Value cannot be less than 0");
    }
}
