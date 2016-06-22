/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.dto;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductDTO {
	
	public static final String JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON_VALUE;

	@JsonProperty("id")
	private int id;
	
	
	@JsonProperty("name")
	private String name;
	
	public ProductDTO() {
	}

	public ProductDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
