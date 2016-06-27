package com.test.kata.supermarket;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

@CsvDataType()
public class Sku {
	
	@CsvField(pos = 1)
	String item;
	
	@CsvField(pos=2)
	String unitPrice;
	
	@CsvField(pos=3)
	String specialPrice;
	
	Integer unitSpecial;
	
	Integer specialEffect;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(String specialPrice) {
		this.specialPrice = specialPrice;
		
	}
	
	public void assignSpecial()
	{
		
		String[] effect = specialPrice.split(" ");
		unitSpecial = new Integer(effect[0]);
		specialEffect = new Integer(effect[2]);

	}
	
	public Integer getUnitSpecial()
	{
		return unitSpecial;
	}
	
	public Integer getSpecialEffect()
	{
		return specialEffect;
	}
	

}
