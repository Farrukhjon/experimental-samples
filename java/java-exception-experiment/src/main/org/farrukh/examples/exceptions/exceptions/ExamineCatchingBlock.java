package main.org.farrukh.examples.exceptions.exceptions;

public class ExamineCatchingBlock {

    public static void main(String[] args) {

        try {
            call();
        } catch (Exception e) {
            assert e instanceof SomeException;
            Throwable cause = e.getCause();
            assert cause instanceof SomeException;
        }

    }

    private static void call() throws SomeException {
        throw new SomeException();
    }

}
