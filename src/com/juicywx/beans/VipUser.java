package com.juicywx.beans;

import java.util.Date;

public class VipUser {
	private int id;
	private String vipNo;//vip's number
	private String openId;//wx's public id
	private String name;//nick name 
	private int sex; 
	private String city;
	private int points;//vip's total credits
	private Date createTime;//when the account is created
	private int exchange;//vip's exchange using his/her credits
	private int checkOutMoney;//vip's total expense
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVipNo() {
		return vipNo;
	}
	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getExchange() {
		return exchange;
	}
	public void setExchange(int exchange) {
		this.exchange = exchange;
	}
	public int getCheckOutMoney() {
		return checkOutMoney;
	}
	public void setCheckOutMoney(int checkOutMoney) {
		this.checkOutMoney = checkOutMoney;
	}
	
}
