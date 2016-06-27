package com.test.kata.supermarket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCart {

	private Checkout checkOutTest =  new Checkout();
	@Before
	public void setUp() throws Exception {
		checkOutTest.beginTransaction();
	}

	@Test
	public void testSetup() {
		Sku testSku = new Sku();
		testSku.setItem("A");
		testSku.setUnitPrice("50");
		testSku.setSpecialPrice("3 for 130");
		assertEquals(testSku.getItem(), checkOutTest.getSkuMap().get("A").getItem());
		assertEquals(testSku.getUnitPrice(), checkOutTest.getSkuMap().get("A").getUnitPrice());
		assertEquals(testSku.getSpecialPrice(), checkOutTest.getSkuMap().get("A").getSpecialPrice());
		
		testSku.setItem("B");
		testSku.setUnitPrice("30");
		testSku.setSpecialPrice("2 for 45");
		
		assertEquals(testSku.getItem(), checkOutTest.getSkuMap().get("B").getItem());
		assertEquals(testSku.getUnitPrice(), checkOutTest.getSkuMap().get("B").getUnitPrice());
		assertEquals(testSku.getSpecialPrice(), checkOutTest.getSkuMap().get("B").getSpecialPrice());
		
		testSku.setItem("C");
		testSku.setUnitPrice("20");
		testSku.setSpecialPrice(null);
		
		assertEquals(testSku.getItem(), checkOutTest.getSkuMap().get("C").getItem());
		assertEquals(testSku.getUnitPrice(), checkOutTest.getSkuMap().get("C").getUnitPrice());
		assertEquals(testSku.getSpecialPrice(), checkOutTest.getSkuMap().get("C").getSpecialPrice());
	
		testSku.setItem("D");
		testSku.setUnitPrice("15");
		testSku.setSpecialPrice(null);
		
		assertEquals(testSku.getItem(), checkOutTest.getSkuMap().get("D").getItem());
		assertEquals(testSku.getUnitPrice(), checkOutTest.getSkuMap().get("D").getUnitPrice());
		assertEquals(testSku.getSpecialPrice(), checkOutTest.getSkuMap().get("D").getSpecialPrice());
	
	}
	
	@Test
	public void testAddSku() {
		checkOutTest.newTransaction("A");
		assertEquals("A", checkOutTest.getCart().getSkuInCart("A").getItem().getItem());
		assertEquals("50", checkOutTest.getCart().getSkuInCart("A").getItem().getUnitPrice());
		assertEquals("3 for 130", checkOutTest.getCart().getSkuInCart("A").getItem().getSpecialPrice());
		assertEquals(1,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(50,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
		
		checkOutTest.newTransaction("A");
		assertEquals("A", checkOutTest.getCart().getSkuInCart("A").getItem().getItem());
		assertEquals("50", checkOutTest.getCart().getSkuInCart("A").getItem().getUnitPrice());
		assertEquals("3 for 130", checkOutTest.getCart().getSkuInCart("A").getItem().getSpecialPrice());
		assertEquals(2,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(100,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
		
		checkOutTest.newTransaction("A");
		assertEquals("A", checkOutTest.getCart().getSkuInCart("A").getItem().getItem());
		assertEquals("50", checkOutTest.getCart().getSkuInCart("A").getItem().getUnitPrice());
		assertEquals("3 for 130", checkOutTest.getCart().getSkuInCart("A").getItem().getSpecialPrice());
		assertEquals(3,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(130,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
		
		checkOutTest.newTransaction("B");
		assertEquals("B", checkOutTest.getCart().getSkuInCart("B").getItem().getItem());
		assertEquals("30", checkOutTest.getCart().getSkuInCart("B").getItem().getUnitPrice());
		assertEquals("2 for 45", checkOutTest.getCart().getSkuInCart("B").getItem().getSpecialPrice());
		assertEquals(1,checkOutTest.getCart().getSkuInCart("B").getNumber().intValue());
		assertEquals(30,checkOutTest.getCart().getSkuInCart("B").getTotalValue().intValue());
		checkOutTest.getCart().calculateCartValue();
		assertEquals(160,checkOutTest.getCart().getCartValue().intValue());
		
	}

	@Test
	public void testRemSku() {
		checkOutTest.newTransaction("A");
		assertEquals("A", checkOutTest.getCart().getSkuInCart("A").getItem().getItem());
		assertEquals("50", checkOutTest.getCart().getSkuInCart("A").getItem().getUnitPrice());
		assertEquals("3 for 130", checkOutTest.getCart().getSkuInCart("A").getItem().getSpecialPrice());
		assertEquals(1,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(50,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
		
		checkOutTest.newTransaction("A");
		assertEquals("A", checkOutTest.getCart().getSkuInCart("A").getItem().getItem());
		assertEquals("50", checkOutTest.getCart().getSkuInCart("A").getItem().getUnitPrice());
		assertEquals("3 for 130", checkOutTest.getCart().getSkuInCart("A").getItem().getSpecialPrice());
		assertEquals(2,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(100,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
		
		checkOutTest.newTransaction("A");
		assertEquals("A", checkOutTest.getCart().getSkuInCart("A").getItem().getItem());
		assertEquals("50", checkOutTest.getCart().getSkuInCart("A").getItem().getUnitPrice());
		assertEquals("3 for 130", checkOutTest.getCart().getSkuInCart("A").getItem().getSpecialPrice());
		assertEquals(3,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(130,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
	
		checkOutTest.removeSkuFromCart("A");
		assertEquals(2,checkOutTest.getCart().getSkuInCart("A").getNumber().intValue());
		assertEquals(100,checkOutTest.getCart().getSkuInCart("A").getTotalValue().intValue());
	
	}



}
