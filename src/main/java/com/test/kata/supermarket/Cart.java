package com.test.kata.supermarket;

import java.util.HashMap;
import java.util.Map.Entry;

public class Cart {
	private Integer cartValue = new Integer(0);
	private HashMap<String,SkuInCart> skuCart = new HashMap<String,SkuInCart>();
	
	public Cart()
	{
	
	}
	
	public SkuInCart getSkuInCart(String add)
	{
		return skuCart.get(add);
	}
	
	/*
	 * add to SKU to the cart
	 * Sku the object to be added to the cart
	 */
	public void addToCart(Sku addItem)
	{
		//itemsInCart.add(addItem);
		if(null!=skuCart.get(addItem.getItem()))
		{
			skuCart.get(addItem.getItem()).addSku();
		}
		else
		{
			SkuInCart aNewSku = new SkuInCart();
			aNewSku.setItem(addItem);
			aNewSku.addSku();
			skuCart.put(addItem.getItem(),aNewSku);
		}
		skuCart.get(addItem.getItem()).addCurrentValue(new Integer(addItem.getUnitPrice()));
		Integer howMany = skuCart.get(addItem.getItem()).getNumber();
		if (null!=addItem.getUnitSpecial())
		{
			if((howMany % addItem.getUnitSpecial())==0)
			{
				Integer howManySpecial = (howMany / addItem.getUnitSpecial()) * addItem.getSpecialEffect();
				Integer currentPrice = howMany * new Integer(addItem.getUnitPrice());
				skuCart.get(addItem.getItem()).setCurrentValue(howManySpecial);
			}
		}
		
	}
	
	/*
	 * Removes the SKU from the cart
	 * Sku the object to be removed from the cart
	 */
	public void removeFromCart(Sku removeItem)
	{
		if(null!=skuCart.get(removeItem.getItem()))
		{
			skuCart.get(removeItem.getItem()).removeSku();
			
			if(skuCart.get(removeItem.getItem()).getNumber()==0)
			{
				skuCart.remove(removeItem.getItem());
			}
			else
			{
				skuCart.get(removeItem.getItem()).subCurrentValue(new Integer(removeItem.getUnitPrice()));
				Integer howMany = skuCart.get(removeItem.getItem()).getNumber();
				/*if(null!=removeItem.getUnitSpecial())
				{
					Integer howManySpecial = (howMany / removeItem.getUnitSpecial()) * removeItem.getSpecialEffect();
					Integer currentPrice = howMany * new Integer(removeItem.getUnitPrice());
					skuCart.get(removeItem.getItem()).setCurrentValue(howManySpecial);
					
				}*/
			}
					
		}
		
	}
	
	/*
	 * Returns the current value of the cart
	 * @Return Integer value of cart
	 */
	public Integer getCartValue()
	{
		return this.cartValue;
	}
	
	
	public void calculateCartValue()
	{
		this.cartValue = 0;
		
		for(Entry<String, SkuInCart> entry  : skuCart.entrySet()) 
		{
			this.cartValue = this.cartValue +entry.getValue().getTotalValue();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Generates a string that represent the current content of the cart
	 * @Return a string that represent the cart
	 */
	public String toString()
	{
		String current = "";
		this.cartValue = 0;
		for(Entry<String, SkuInCart> entry  : skuCart.entrySet()) 
		{
			current = current +"There are currently "+entry.getValue().getNumber() + " "+entry.getValue().getItem().getItem() + " at a cost of "+entry.getValue().getTotalValue()+"\n";
			this.cartValue = this.cartValue +entry.getValue().getTotalValue();
		}
		current = current + "Current cart value  is "+cartValue;
		return current;
		
	}
	
}
