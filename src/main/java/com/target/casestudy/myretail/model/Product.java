package com.target.casestudy.myretail.model;

public class Product {

	private int id;
	private String name;
	private Amount currentPrice;
	
	public Product(){
		
	}
	
	public Product(int id, String name, long price, String currency){
		this.id = id;
		this.name = name;
		Amount amt = new Amount();
		amt.setValue(price);
		CurrencyEnum currencyCode = CurrencyEnum.valueOf(currency);
		amt.setCurrencyCode(currencyCode);
		this.currentPrice = amt;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Amount getCurrentPrice() {
		return currentPrice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentPrice(Amount currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	@Override
	public String toString(){
		return "id:"+id+" name:"+name+" price:"+currentPrice;
	}
	
}
