/**
 * 
 */
package com.google.gson.databinding.fromAndBack.exam2;

/**
 * @author Farrukhjon SATTOROV, Dec 9, 2014
 *
 */
public class DataContainer {

	private String test1_id;
	private String test2_id;

	public String getTest1_id() {
		return test1_id;
	}

	public void setTest1_id(String test1_id) {
		this.test1_id = test1_id;
	}

	public String getTest2_id() {
		return test2_id;
	}

	public void setTest2_id(String test2_id) {
		this.test2_id = test2_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "test1_id:" + test1_id + " test2_id:" + test2_id;
	}

}
