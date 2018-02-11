package com.emidstest.hicalc.exception;

/**
 * The Class PremiumCalcException.
 */
/**
 * @author sriram
 */
public class BaseCalculatorException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -3524947938105653659L;

	public BaseCalculatorException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	private String	errorCode;
	private String	errorMsg;

}
