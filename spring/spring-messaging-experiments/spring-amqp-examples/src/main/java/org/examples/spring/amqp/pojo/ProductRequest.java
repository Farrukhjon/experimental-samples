/**
 * 
 */
package org.examples.spring.amqp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductRequest {

	@JsonProperty("requestId")
	private int requestId;
	
	@JsonProperty("command")
	private String command;
	
	@JsonProperty("contectType")
	private String contectType;
	
	public String getContectType() {
		return contectType;
	}

	public ProductRequest(int requestId, String command, String contectType) {
		this.requestId = requestId;
		this.command = command;
		this.contectType = contectType;
	}

	public void setContectType(String contectType) {
		this.contectType = contectType;
	}

	public ProductRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
