package HT.HT3;

public class WrongLoginException extends Exception {
    public WrongLoginException(String msg) {
        super(msg);
    }

    public WrongLoginException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
