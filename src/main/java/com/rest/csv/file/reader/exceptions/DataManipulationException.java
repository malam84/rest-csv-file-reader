package com.rest.csv.file.reader.exceptions;

/**
 * 
 * @author malam84
 *
 */

public class DataManipulationException extends Exception {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new data manipulation exception.
     *
     * @param message the message
     */
    public DataManipulationException(String message) {
        super(message);
    }

    /**
     * Instantiates a new data manipulation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DataManipulationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new data manipulation exception.
     *
     * @param cause the cause
     */
    public DataManipulationException(Throwable cause) {
        super(cause);
    }
}
