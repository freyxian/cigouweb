package com.cigouweb.controller;

import java.util.ArrayList;
import java.util.List;

import CigouDAO.CDAO.WholeOrder;
import CigouDAO.cigoudb.WhOrderHeader;
import CigouDAO.cigoudb.WhOrderItems;
import CigouDAO.cigoudb.WhOrderItemsId;
import CigouDAO.cigoudb.WhRefTplHome;

public class OrderInputForm {
	//Wh_order_header
	private String orderId;
	private String orderDate;
	private String customerId;
	private String packingMaterial;
	private String warehouseId;
	private String whRefTpl;
	private int orderType;
	private String electriccode;
	private String deliveryCode;
	private String notes;
	private String cbepcomcode;

	//Wh_order_recipient
	private String name;
	private Integer receiveType;
	private String receiveNo;
	private String mobilePhone;
	private String phone;
	private String country;
	private String province;
	private String city;
	private String district;
	private String address;
	private String postcode;
	
	private boolean confirmed;
	
	
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	//Wh_order_items
	private List<OrderItemsForm> orderItemList;

	public OrderInputForm(){
		this.orderId=" ";
		this.orderDate=" ";
		this.customerId=" ";
		this.packingMaterial=" ";
		this.warehouseId=" ";
		this.whRefTpl=" ";
		this.orderType=0;
		this.electriccode=" ";
		this.deliveryCode=" ";
		this.notes=" ";
		this.cbepcomcode=" ";

		//Wh_order_recipient
		this.name=" ";
		this.receiveType=0;
		this.receiveNo=" ";
		this.mobilePhone=" ";
		this.phone=" ";
		this.country=" ";
		this.province=" ";
		this.city=" ";
		this.district=" ";
		this.address=" ";
		this.postcode=" ";
		
		this.confirmed=false;
		
		this.orderItemList=new ArrayList<OrderItemsForm>();
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPackingMaterial() {
		return packingMaterial;
	}

	public void setPackingMaterial(String packingMaterial) {
		this.packingMaterial = packingMaterial;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWhRefTpl() {
		return whRefTpl;
	}

	public void setWhRefTpl(String tpl) {
		this.whRefTpl = tpl;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getElectriccode() {
		return electriccode;
	}

	public void setElectriccode(String electriccode) {
		this.electriccode = electriccode;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCbepcomcode() {
		return cbepcomcode;
	}

	public void setCbepcomcode(String cbepcomcode) {
		this.cbepcomcode = cbepcomcode;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReceiveType() {
		return receiveType;
	}

	public void setReceiveType(Integer receiveType) {
		this.receiveType = receiveType;
	}

	public String getReceiveNo() {
		return receiveNo;
	}

	public void setReceiveNo(String receiveNo) {
		this.receiveNo = receiveNo;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public List<OrderItemsForm> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemsForm> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	public void BindOrder(WholeOrder wo){
		this.orderId=wo.getHeader().getOrderId();
		this.orderDate=wo.getHeader().getOrderDate();
		this.customerId=wo.getHeader().getCustomerId();
		this.packingMaterial=wo.getHeader().getPackingMaterial();
		this.warehouseId=wo.getHeader().getWarehouseId();
		this.whRefTpl=wo.getHeader().getWhRefTpl().getTpl();
		this.orderType=wo.getHeader().getOrderType();
		this.electriccode=wo.getHeader().getElectriccode();
		this.deliveryCode=wo.getHeader().getDeliveryCode();
		this.notes=wo.getHeader().getNotes();
		this.cbepcomcode=wo.getHeader().getCbepcomcode();

		//Wh_order_recipient
		this.name=wo.getRecipient().getName();
		this.receiveType=wo.getRecipient().getReceiveType();
		this.receiveNo=wo.getRecipient().getReceiveNo();
		this.mobilePhone=wo.getRecipient().getMobilePhone();
		this.phone=wo.getRecipient().getPhone();
		this.country=wo.getRecipient().getCountry();
		this.province=wo.getRecipient().getProvince();
		this.city=wo.getRecipient().getCity();
		this.district=wo.getRecipient().getDistrict();
		this.address=wo.getRecipient().getAddress();
		this.postcode=wo.getRecipient().getPostcode();
		this.confirmed=wo.isConfirmed();
		
		ArrayList<OrderItemsForm> al = new ArrayList<OrderItemsForm>();
		for (WhOrderItems woi: wo.getItems()){
			OrderItemsForm oif=new OrderItemsForm();
			oif.BindItem(woi);
			al.add(oif);
		}
		this.orderItemList=al;
		
		//release resource
		wo=null;
	}
	
	public WholeOrder Form2Order(){
		WholeOrder wo =new WholeOrder();
		wo.getHeader().setOrderId(this.orderId);
		wo.getHeader().setOrderDate(this.orderDate);
		wo.getHeader().setCustomerId(this.customerId);
		wo.getHeader().setPackingMaterial(this.packingMaterial);
		wo.getHeader().setWarehouseId(this.warehouseId);
		WhRefTplHome tplhome=new WhRefTplHome();
		wo.getHeader().setWhRefTpl(tplhome.findById(this.whRefTpl));
		wo.getHeader().setOrderType(this.orderType);
		wo.getHeader().setElectriccode(this.electriccode);
		wo.getHeader().setDeliveryCode(this.deliveryCode);
		wo.getHeader().setNotes(this.notes);
		wo.getHeader().setCbepcomcode(this.cbepcomcode);

		//Wh_order_recipient
		wo.getRecipient().setOrderId(this.orderId);
		wo.getRecipient().setName(this.name);
		wo.getRecipient().setReceiveType(this.receiveType);
		wo.getRecipient().setReceiveNo(this.receiveNo);
		wo.getRecipient().setMobilePhone(this.mobilePhone);
		wo.getRecipient().setPhone(this.phone);
		wo.getRecipient().setCountry(this.country);
		wo.getRecipient().setProvince(this.province);
		wo.getRecipient().setCity(this.city);
		wo.getRecipient().setDistrict(this.district);
		wo.getRecipient().setAddress(this.address);
		wo.getRecipient().setPostcode(this.postcode);
		wo.getRecipient().setWhOrderHeader(wo.getHeader());
		
		ArrayList<WhOrderItems> al = new ArrayList<WhOrderItems>();
		for (OrderItemsForm woif: this.orderItemList){
			WhOrderItems oif=new WhOrderItems();
			WhOrderItemsId oifid=new WhOrderItemsId(this.orderId,woif.getGoodId());
			oif.setId(oifid);
			oif.setAmount(woif.getAmount());
			oif.setPrice(woif.getPrice());
			oif.setWhOrderHeader(wo.getHeader());
			al.add(oif);
		}
		wo.setItems(al);
		
		return wo;
	}
}
