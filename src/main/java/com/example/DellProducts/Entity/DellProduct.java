package com.example.DellProducts.Entity;

import com.example.DellProducts.Model.DellproductDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DellProduct {
	@Id
	private int billNumber;
	private String productName;
	private String productBrand;
	private String productSeries;
	private Double productPrice;
	private String customerName;
	private Long customerContact;
	private String customerEmail;

	public static DellproductDto getproductModel(DellProduct dellProduct) {
		
		DellproductDto dellproductDto=new DellproductDto();
		dellproductDto.setBillNumber(dellProduct.getBillNumber());
		dellproductDto.setProductName(dellProduct.getProductName());
		dellproductDto.setProductBrand(dellProduct.getProductBrand());
		dellproductDto.setProductSeries(dellProduct.getProductSeries());
		dellproductDto.setProductPrice(dellProduct.getProductPrice());
		dellproductDto.setCustomerName(dellProduct.getCustomerName());
		dellproductDto.setCustomerEmail(dellProduct.getCustomerEmail());
		dellproductDto.setCustomerContact(dellProduct.getCustomerContact());
		return dellproductDto;
		
	}
}
