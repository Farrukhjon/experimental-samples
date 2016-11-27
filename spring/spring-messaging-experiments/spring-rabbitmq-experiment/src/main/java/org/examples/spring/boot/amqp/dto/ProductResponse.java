/**
 * 
 */
package org.examples.spring.boot.amqp.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductResponse {

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("price")
	private Double price;
	
	@JsonProperty("error")
	private boolean error;
	
	@JsonProperty("errorMessage")
	private String errorMessage;
	
	@JsonProperty("timestamp")
	private long timestamp = new Date().getTime();
	
	@JsonProperty("products")
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ProductResponse [requestId=" + requestId + ", price=" + price + ", error=" + error + ", errorMessage="
				+ errorMessage + ", timestamp=" + timestamp + "]";
	}
	
}
