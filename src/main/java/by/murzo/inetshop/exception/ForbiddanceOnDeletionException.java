package by.murzo.inetshop.exception;

public class ForbiddanceOnDeletionException extends Exception {
    public ForbiddanceOnDeletionException() {
    }

    public ForbiddanceOnDeletionException(String message) {
        super(message);
    }

    public ForbiddanceOnDeletionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddanceOnDeletionException(Throwable cause) {
        super(cause);
    }
}
