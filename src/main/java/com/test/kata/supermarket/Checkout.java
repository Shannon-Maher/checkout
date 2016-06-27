package com.test.kata.supermarket;

import java.io.InputStreamReader;
import java.util.HashMap;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.config.CsvConfiguration;

public class Checkout {

	private HashMap<String,Sku> skuMap = new HashMap<String,Sku>();
	private Cart theCart = new Cart();
	
	
	/*
	 * Adds the contents of the csv file into the skuMap
	 */
	private void setUpMap()
	{
		CsvConfiguration config = new CsvConfiguration();
		config.setFieldDelimiter(',');
		
		Deserializer deserializer = CsvIOFactory.createFactory(config,Sku.class).createDeserializer();
		InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/sku.csv"));
		deserializer.open(reader);
		while (deserializer.hasNext()) {
			Sku aSku = deserializer.next();
			if(null != aSku.getSpecialPrice())
				aSku.assignSpecial();
			skuMap.put(aSku.getItem(), aSku);
		    
		}
		deserializer.close(true);	
	}
	
	/*
	 * Return hashmap of sku
	 * @return Hashmap of SKU
	 */
	public HashMap<String,Sku> getSkuMap()
	{
		return skuMap;
	}
	
	/*
	 * Start a new transaction by opening a file connection
	 */
	public void beginTransaction()
	{
		setUpMap();
	}
	
	/*
	 * Add a new SKU to the shopping cart
	 * @key A key to be added to the shopping cart
	 */
	public void newTransaction(String key)
	{
		Sku aSku = skuMap.get(key);
		theCart.addToCart(aSku);
		
	}
	
	/*Removes a SKU from the cart
	 * @param key The SKU key to be removed from the shopping cart
	 */
	public void removeSkuFromCart(String key)
	{
		Sku aSku = skuMap.get(key);
		theCart.removeFromCart(aSku);
	}
	
	/*
	 * Prints out the current status of the shopping cart
	 */
	public void printCart()
	{
		System.out.println(theCart.toString());
	}
	
	public Cart getCart()
	{
		return this.theCart;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Checkout bgCheckout = new Checkout();
		bgCheckout.beginTransaction();
		bgCheckout.newTransaction("A");
		bgCheckout.newTransaction("A");
		bgCheckout.newTransaction("A");
		bgCheckout.newTransaction("A");
		bgCheckout.newTransaction("A");
		bgCheckout.newTransaction("A");
		bgCheckout.newTransaction("B");
		bgCheckout.newTransaction("B");
		bgCheckout.printCart();
		bgCheckout.removeSkuFromCart("A");
		bgCheckout.newTransaction("C");
		bgCheckout.printCart();
		bgCheckout.removeSkuFromCart("C");
		bgCheckout.printCart();
		bgCheckout.removeSkuFromCart("B");
		bgCheckout.printCart();
	}

}
