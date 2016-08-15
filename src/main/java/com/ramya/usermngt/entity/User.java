package com.ramya.usermngt.entity;

import java.util.Date;

class Address {

	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;

	public void setstreet(String street) {
		this.street = street;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public void setstate(String state) {
		this.state = state;
	}

	public void setzip(String zip) {
		this.zip = zip;
	}

	public void setcountry(String country) {
		this.country = country;
	}

	public String getstreet() {
		return street;
	}

	public String getcity() {
		return city;
	}

	public String getzip() {
		return zip;
	}

	public String getstate() {
		return state;
	}

	public String getcountry() {
		return country;
	}

	public Address() {

	}

}

class Company {
	private String name;
	private String website;

	public void setname(String name) {
		this.name = name;
	}

	public void setwebsite(String website) {
		this.website = website;
	}

	public String getname() {
		return name;
	}

	public String getwebsite() {
		return website;
	}
}

public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Date Date = new Date();
	private String profilepic;
	private Address address;
	private Company company;

	public User() {

		setAddress(new Address());
		company = new Company();

	}

	public void setid(String id) {

		this.id = id;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public void setprofilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	public String getid() {
		return id;
	}

	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public String getemail() {
		return email;
	}

	public Date getDate() {
		return Date;
	}

	public String getprofilepic() {
		return profilepic;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}