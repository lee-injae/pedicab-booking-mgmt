package com.pedicab.models;

import java.util.Objects;

public class Tour {
	private int tourId;
	private String tourName;
	private int price;
	
	public Tour() {
		super();
	}
	
	public Tour(int tourId, String tourName, int price) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.price = price;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, tourId, tourName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return price == other.price && tourId == other.tourId && Objects.equals(tourName, other.tourName);
	}

	@Override
	public String toString() {
		return "Tours [tourId=" + tourId + ", tourName=" + tourName + ", price=" + price + "]";
	}
	
}
