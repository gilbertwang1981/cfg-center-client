package com.qsk.base.cfg.impl;

import com.qsk.base.cfg.annotation.CfgCenterBooleanValue;
import com.qsk.base.cfg.annotation.CfgCenterComponent;
import com.qsk.base.cfg.annotation.CfgCenterDoubleValue;
import com.qsk.base.cfg.annotation.CfgCenterIntegerValue;
import com.qsk.base.cfg.annotation.CfgCenterLongValue;
import com.qsk.base.cfg.annotation.CfgCenterStringValue;

@CfgCenterComponent(service = "${cfg.service.name}" , desc = "${cfg.service.desc}")
public class CfgService {
	@CfgCenterStringValue(propName = "name" , defaultValue="王晗" , desc = "名字")
	private String name;
	@CfgCenterLongValue(propName = "num" , defaultValue=32 , desc = "数量")
	private Long num;
	@CfgCenterDoubleValue(propName = "price" , defaultValue=345.65 , desc = "价格")
	private Double price;
	@CfgCenterBooleanValue(propName = "is_open" , defaultValue=false , desc = "是否打开")
	private Boolean isOpen;
	@CfgCenterIntegerValue(propName = "age" , defaultValue=32 , desc = "年龄")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
