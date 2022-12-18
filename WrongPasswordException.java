package HT.HT3;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String msg) {
        super(msg);
    }

    public WrongPasswordException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
