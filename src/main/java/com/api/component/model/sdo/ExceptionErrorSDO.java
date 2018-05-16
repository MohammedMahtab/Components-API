package com.api.component.model.sdo;


public class ExceptionErrorSDO {
	
	private String code;
	private String userMessage;
	private String systemMessage;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getSystemMessage() {
		return systemMessage;
	}
	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}
	public ExceptionErrorSDO(String code, String userMessage, String systemMessage) {
		super();
		this.code = code;
		this.userMessage = userMessage;
		this.systemMessage = systemMessage;
	}

	
}
