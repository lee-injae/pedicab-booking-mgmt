package com.pedicab.models;

import java.util.Objects;

public class Rider {
	
	private int riderId;
	private String rider_name;
	private String rider_email;
	private String rider_password;
	
	public Rider() {
		super();
	}

	public int getRiderId() {
		return riderId;
	}

	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}

	public String getRider_name() {
		return rider_name;
	}

	public void setRider_name(String rider_name) {
		this.rider_name = rider_name;
	}

	public String getRider_email() {
		return rider_email;
	}

	public void setRider_email(String rider_email) {
		this.rider_email = rider_email;
	}

	public String getRider_password() {
		return rider_password;
	}

	public void setRider_password(String rider_password) {
		this.rider_password = rider_password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(riderId, rider_email, rider_name, rider_password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rider other = (Rider) obj;
		return riderId == other.riderId && Objects.equals(rider_email, other.rider_email)
				&& Objects.equals(rider_name, other.rider_name) && Objects.equals(rider_password, other.rider_password);
	}

	@Override
	public String toString() {
		return "Riders [riderId=" + riderId + ", rider_name=" + rider_name + ", rider_email=" + rider_email
				+ ", rider_password=" + rider_password + "]";
	}

}
