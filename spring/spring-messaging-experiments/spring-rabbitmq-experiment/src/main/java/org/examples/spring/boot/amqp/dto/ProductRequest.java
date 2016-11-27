/**
 * 
 */
package org.examples.spring.boot.amqp.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductRequest {
	
	@JsonProperty("requestId")
	private String requestId;
	
	@JsonProperty("command")
	private String command;
	
	@JsonProperty("price")
	private Double price;
	
	@JsonProperty("contentType")
	private String contentType;
	
	@JsonProperty("correlationId")
	private String correlationId = UUID.randomUUID().toString();

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public ProductRequest() {
		// TODO Auto-generated constructor stub
	}

	public ProductRequest(String command, Double price) {
		this.command = command;
		this.price = price;
	}
	
}
