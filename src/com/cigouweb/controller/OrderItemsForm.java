package com.cigouweb.controller;

import CigouDAO.cigoudb.WhOrderItems;

public class OrderItemsForm {
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	private String orderId;
	private String goodId;
	private int amount;
	private float price;

	
	public void BindItem(WhOrderItems whoi){
		this.orderId=whoi.getId().getOrderId();
		this.goodId=whoi.getId().getGoodId();
		this.amount=whoi.getAmount();
		this.price=whoi.getPrice();

	}
}
