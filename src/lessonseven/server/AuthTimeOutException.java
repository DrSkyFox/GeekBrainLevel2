package lessonseven.server;

public class AuthTimeOutException extends Exception{

    private int timeOut;
    private static final String msg = "Authentication timed out: ";

    public AuthTimeOutException(String message, int timeOut) {
        super(message);
        this.timeOut = timeOut;
    }

    public AuthTimeOutException(String message, Throwable cause, int timeOut) {
        super(message, cause);
        this.timeOut =timeOut;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " " + msg +  timeOut;
    }
}
