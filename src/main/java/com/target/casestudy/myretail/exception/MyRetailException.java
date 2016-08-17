package com.target.casestudy.myretail.exception;

@SuppressWarnings("serial")
public class MyRetailException extends Exception {
	
    public MyRetailException() {
        super();
    }

    public MyRetailException(String message) {
        super(message);
    }

    public MyRetailException(Throwable cause) {
        super(cause);
    }

    public MyRetailException(String message, Throwable cause) {
        super(message, cause);
    }

}
