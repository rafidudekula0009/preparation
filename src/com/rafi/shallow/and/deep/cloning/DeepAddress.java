package com.rafi.shallow.and.deep.cloning;

public class DeepAddress implements Cloneable{
	String houseNo;
	String streetName;
	int pincode;
	
	public DeepAddress(String houseNo, String streetName, int pincode) {
		super();
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.pincode = pincode;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetName=" + streetName + ", pincode=" + pincode + "]";
	}
}
