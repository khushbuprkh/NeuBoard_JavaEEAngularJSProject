package com.neu.edu.pojo;


import javax.persistence.Embeddable;


@Embeddable
public class Address {

	private String streetOne;
	private String streetTwo;
	private String city;
	private String state;
	private String country;
	
	public Address()
	{}
	public Address(String streetOne,String streetTwo,String country,String state,String city)
	{
		this.streetOne=streetOne;
		this.streetTwo=streetTwo;
		this.country=country;
		this.state=state;
		this.city=city;	
	}

	public String getStreetOne() {
		return streetOne;
	}

	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	public String getStreetTwo() {
		return streetTwo;
	}

	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
