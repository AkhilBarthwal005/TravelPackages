package exception;

/**
 * An exception class to represent the case when an invalid activity number is encountered.
 * This exception can be thrown when attempting to perform an operation with an invalid activity number.
 */
public class InvalidActivityNumberException extends Throwable {
    /**
     * Constructs an InvalidActivityNumberException with the specified detail message.
     *
     * @param please_provide_correct_activity_id The detail message indicating the reason for the exception.
     */
    public InvalidActivityNumberException(String please_provide_correct_activity_id) {
        super(please_provide_correct_activity_id);
    }
}
