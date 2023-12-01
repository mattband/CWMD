/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Newsagent;

/**
 *
 * @author cianf
 */
public class NewsagentExceptionHandler extends Exception{
	
	String message;
	
	public NewsagentExceptionHandler(String errMessage) {
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

}
