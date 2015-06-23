package exception;


public class WebException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private ServiceException exception;

    public WebException(ServiceException exception) {
        this.exception = exception;
        
    }

    public Exception getException() {
        return exception;
    }

    public void setException(ServiceException exception) {
        this.exception = exception;
    }
}
