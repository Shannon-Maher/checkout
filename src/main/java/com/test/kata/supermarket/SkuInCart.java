package com.test.kata.supermarket;

public class SkuInCart {
	private Sku item;
	private Integer number = new Integer(0);
	private Integer totalValue = new Integer(0);
	
	/*
	 * Returns a SKU 
	 * @param item gets a SKU
	 */
	public Sku getItem() {
		return item;
	}
	
	/*
	 * Adds a SKU to the cart
	 * @param item a SKU to be added to the cart
	 */
	public void setItem(Sku item) {
		this.item = item;
	}
	
	/*
	 * The number of SKU
	 * @param Integer get the number of SKUs
	 */
	public Integer getNumber() {
		return number;
	}
	
	/*
	 * adds a SKU to the cart
	 */
	public void addSku() {
		number++;
	}
	
	/*
	 * get the number of SKU
	 * @param Integer the number of SKUs for this type in the cart
	 */
	public Integer getSkuNumber()
	{
		return number;
	}
	
	/*
	 * subtracts the number of SKU 
	 */
	public void removeSku()
	{
		number--;
	}
	
	public void addCurrentValue(Integer value)
	{
		totalValue = totalValue + value ;
	}
	
	/*
	 * Subtracts the current value from the SKU
	 * @param value the value to be deducted
	 */
	public void subCurrentValue(Integer value)
	{
		Integer lot = number % item.getUnitSpecial();
		if (lot > 1)
			lot --;
		
		Integer nonDiscount = (lot * item.getUnitSpecial()) * new Integer(item.getUnitPrice());
 		Integer tempLot = lot * item.getSpecialEffect();
 		Integer remain = totalValue - tempLot;
		totalValue = remain + (nonDiscount-value);
	}
	
	/*
	 * clears the value for the SKU
	 */
	public void clearCurrentValue()
	{
		totalValue = 0;
	}
	
	/*
	 * Sets the value of all of the SKUs of that type
	 * @param value sets the value
	 */
	public void setCurrentValue(Integer value)
	{
		totalValue =value;
	}
	
	/*
	 * Total value of the SKU on cart
	 * @Return Integer the value of the cart
	 */
	public Integer getTotalValue()
	{
		return totalValue;
	}
	
}
