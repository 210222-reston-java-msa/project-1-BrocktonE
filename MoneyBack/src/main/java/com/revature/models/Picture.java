package com.revature.models;

import java.util.Arrays;

public class Picture {

	
	
	private byte[] picture;
	
	
	
	public Picture() {
		super();
	}
	
	public Picture( byte[] picture) {
	
	this.picture = picture;
}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Picture [picture=" + Arrays.toString(picture) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(picture);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		if (!Arrays.equals(picture, other.picture))
			return false;
		return true;
	}
	
}
