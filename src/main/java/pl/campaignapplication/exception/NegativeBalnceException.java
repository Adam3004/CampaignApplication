package pl.campaignapplication.exception;

public class NegativeBalnceException extends Exception {
    public NegativeBalnceException() {
        System.out.println("Balance cannot be smaller than 0");
    }
}
