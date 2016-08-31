package dto;

import java.io.Serializable;

/**
 * @author Farrukhjon SATTOROV
 * 
 */
public class Address implements Serializable {

	private long	idAddress;
	private String	region;
	private String	city;
	private String	province;
	private String	street;
	private String	homePhone;
	private String	workPhone;
	private String	mobilePhone;
	private String	email;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	public long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(long idAddress) {
		this.idAddress = idAddress;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
