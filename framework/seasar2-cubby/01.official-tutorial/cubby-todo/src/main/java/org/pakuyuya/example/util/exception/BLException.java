package org.pakuyuya.example.util.exception;

/**
 * Buisines Logic Exception
 */
public class BLException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BLException(Throwable th) {
        super(th);
    }
}
