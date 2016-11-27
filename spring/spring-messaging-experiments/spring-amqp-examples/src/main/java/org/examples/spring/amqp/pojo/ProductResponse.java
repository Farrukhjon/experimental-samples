/**
 * 
 */
package org.examples.spring.amqp.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductResponse {
	
	@JsonProperty("responseId")
	private int responseId;
	
	@JsonProperty("contentType")
	private String contentType;
	
	@JsonProperty("correlationId")
	private String correlationId;
	
	@JsonProperty("contentEncoding")
	private String contentEncoding;
	
	@JsonProperty("products")
	private List<Product> products;
	
	@JsonProperty("timestamp")
	private long timestamp = new Date().getTime();

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getContentEncoding() {
		return contentEncoding;
	}

	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
