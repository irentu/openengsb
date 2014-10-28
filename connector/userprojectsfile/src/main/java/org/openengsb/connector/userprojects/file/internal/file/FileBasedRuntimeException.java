package org.openengsb.connector.userprojects.file.internal.file;

/**
 * Represents an unchecked exception that can occur within the context of file-based user data manager.
 *
 */
public class FileBasedRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 6267165144631084590L;

    public FileBasedRuntimeException() {
        super();
    }

    public FileBasedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileBasedRuntimeException(String message) {
        super(message);
    }

    public FileBasedRuntimeException(Throwable cause) {
        super(cause);
    }

}
