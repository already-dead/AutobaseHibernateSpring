package exception;


public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private DaoException exception;

    public ServiceException(DaoException exception) {
        this.exception = exception;  
    }

    public Exception getException() {
        return exception;
    }

    public void setException(DaoException exception) {
        this.exception = exception;
    }
}
