/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ErrorMessageDTO {

	@JsonProperty("status_code")
	private int statusCode;

	@JsonProperty("status_message")
	private String statusMessage;

	@JsonProperty("detailed_message")
	private DetaliedMessage detailedMessage;

	public static class DetaliedMessage {
		private String detail;

		public DetaliedMessage(String detail) {
			this.detail = detail;
		}

		public String getDetail() {
			return detail;
		}
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public DetaliedMessage getDetailedMessage() {
		return detailedMessage;
	}

	public void setDetailedMessage(DetaliedMessage detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

}
