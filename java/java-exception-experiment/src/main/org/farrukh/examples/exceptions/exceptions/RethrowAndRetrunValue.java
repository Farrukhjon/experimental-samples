package main.org.farrukh.examples.exceptions.exceptions;

public class RethrowAndRetrunValue {

    public static void main(String[] args) throws Exception {

        Object avlaue = callThrowsException();
        assert avlaue != null;

    }

    private static Object callThrowsException() throws Exception {
        Object avalue = null;
        try {
            getValue();
            avalue = new Object();
            return avalue;
        } catch (Exception e) {
        }
        return avalue;
    }

    private static void getValue() throws Exception {
        throw  new Exception("Exception");
    }

}
