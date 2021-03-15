package com.revature.models;

public class AuthorId {

	private int aid;
	private String un;

	public AuthorId() {
		super();
	}


	public AuthorId(int aid, String un) {
	super();
		this.aid = aid;
		this.un = un;
	}


	public int getAid() {
		return aid;
	}


	public void setAid(int aid) {
		this.aid = aid;
	}


	public String getUn() {
		return un;
	}


	public void setUn(String un) {
		this.un = un;
	}


	@Override
	public String toString() {
		return "AuthorId [aid=" + aid + ", un=" + un + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((un == null) ? 0 : un.hashCode());
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
		AuthorId other = (AuthorId) obj;
		if (aid != other.aid)
			return false;
		if (un == null) {
			if (other.un != null)
				return false;
		} else if (!un.equals(other.un))
			return false;
		return true;
	}

}