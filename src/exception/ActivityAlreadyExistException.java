package exception;

/**
 * Exception class to represent a situation where an activity already exists.
 * This exception can be thrown when attempting to add an activity that already exists.
 */
public class ActivityAlreadyExistException extends Throwable {

    /**
     * Constructs a new ActivityAlreadyExistException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public ActivityAlreadyExistException(String message) {
        super(message);
    }
}
