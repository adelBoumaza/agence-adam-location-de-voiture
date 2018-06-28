package dz.agenceadam.locationvoiture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
@SuppressWarnings("serial")
public class DataFoundedException extends Exception {

	public DataFoundedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataFoundedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataFoundedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataFoundedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataFoundedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
 
	
}
