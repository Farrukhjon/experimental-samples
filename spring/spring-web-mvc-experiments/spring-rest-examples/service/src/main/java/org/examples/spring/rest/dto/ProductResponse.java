/**
 * 
 */
package org.examples.spring.rest.dto;

import java.util.List;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductResponse {

	private List<Product> roducts;
	private int statusCode;
	private String statusMessage;
	private String detailedMessage;

	public final List<Product> getRoducts() {
		return roducts;
	}

	public final void setRoducts(List<Product> roducts) {
		this.roducts = roducts;
	}

	public final int getStatusCode() {
		return statusCode;
	}

	public final void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public final String getStatusMessage() {
		return statusMessage;
	}

	public final void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public final String getDetailedMessage() {
		return detailedMessage;
	}

	public final void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}
}
