package cn.com.leave.exception;

/**
 * Created by chenlu on 2016/2/1.
 */
public class CauseException extends RuntimeException {
    public CauseException() {
    }

    public CauseException(String message) {
        super(message);
    }

    public CauseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CauseException(Throwable cause) {
        super(cause);
    }
}
