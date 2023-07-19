package com.example.DellProducts.Model;

import com.example.DellProducts.Entity.DellProduct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DellproductDto {
	
	private int billNumber;
	private String productName;
	private String productBrand;
	private String productSeries;
	private Double productPrice;
	private String customerName;
	private Long customerContact;
	private String customerEmail;
	
	public static DellProduct createEntity(DellproductDto dellproductDto) {
		
		DellProduct product=new DellProduct();
		product.setBillNumber(dellproductDto.getBillNumber());
		product.setProductName(dellproductDto.getProductName());
		product.setProductBrand(dellproductDto.getProductBrand());
		product.setProductSeries(dellproductDto.getProductSeries());
		product.setProductPrice(dellproductDto.getProductPrice());
		product.setCustomerName(dellproductDto.getCustomerName());
		product.setCustomerEmail(dellproductDto.getCustomerEmail());
		product.setCustomerContact(dellproductDto.getCustomerContact());
		return product;
		
	}
	

}
