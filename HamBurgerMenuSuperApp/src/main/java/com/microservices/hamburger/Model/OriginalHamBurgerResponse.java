/**
 * 
 */
package com.microservices.hamburger.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 33000006
 *
 */
public class OriginalHamBurgerResponse {
	
	private int status;
	private int errorCode;
	private String messageType;
	private String message;
	private List<HamBurgerResponse> menu;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<HamBurgerResponse> getMenu() {
		return menu;
	}
	public void setMenu(List<HamBurgerResponse> menu) {
		this.menu = menu;
	}
	@JsonCreator
	public OriginalHamBurgerResponse(@JsonProperty("Status") int status,@JsonProperty("ErrorCode") int errorCode,@JsonProperty("MessageType") String messageType,@JsonProperty("Message") String message,
		@JsonProperty("Menu")	List<HamBurgerResponse> menu) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.messageType = messageType;
		this.message = message;
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "OriginalHamBurgerResponse [status=" + status + ", errorCode=" + errorCode + ", messageType="
				+ messageType + ", message=" + message + ", menu=" + menu + "]";
	}
	
	

}
