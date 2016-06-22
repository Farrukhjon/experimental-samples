/**
 * 
 */
package com.google.gson.databinding.fromAndBack.exam2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Farrukhjon SATTOROV, Dec 9, 2014
 *
 */
public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		
		Reader json = new FileReader("src/main/resources/jsonContainer.json");
		
		Gson gson = new GsonBuilder().create();
		JsonContainer jsonContainer = gson.fromJson(json, JsonContainer.class);
		
		ResultContainer results = jsonContainer.getResults();
		System.out.println(results.getDetails());
	}

}
