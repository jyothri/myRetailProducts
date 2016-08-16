package com.target.casestudy.myretail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Amount {

	@JsonIgnore
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private long value;
	private CurrencyEnum currencyCode;
	
	public long getValue() {
		return value;
	}
	public CurrencyEnum getCurrencyCode() {
		return currencyCode;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public void setCurrencyCode(CurrencyEnum currencyCode) {
		this.currencyCode = currencyCode;
	} 
	
	@Override
	public String toString(){
		return value+currencyCode.name();
	}
}
