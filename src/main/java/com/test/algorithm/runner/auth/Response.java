/**
 * @author Sumitha Jothiramalingam
 *
 */
package com.test.algorithm.runner.auth;

/**
 * Response Object Structure Which remains common as a response format for all
 * API calls
 */
public class Response {
	/**
	 * Any Messages on exceptions during REST calls are set to this parameter
	 */
	private String exceptionMessage;
	/**
	 * This is set to true if there is an exception and false if there isn't any
	 */
	private Boolean isException;
	/**
	 * The Response data is converted into a JSON format and returned through this
	 * object
	 */
	Object responseData;
	/**
	 * This represents the response message with which we could identify if its
	 * Successful or not.
	 */
	private String responseMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public Boolean getIsException() {
		return isException;
	}

	public Object getResponseData() {
		return responseData;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public void setIsException(Boolean isException) {
		this.isException = isException;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
