package com.example.DellProducts.Service;

import java.util.List;

import com.example.DellProducts.Model.DellproductDto;

public interface DellproductService {
	
	public void addDellproduct(DellproductDto dellproductDto)throws Exception;
	public DellproductDto getDellproducts(int billNumber)throws Exception;
	public void updateDellproduct(DellproductDto dellproductDto)throws Exception;
	public void deleteDellproduct(int billNumber)throws Exception;
	public List<DellproductDto> getallDellproducts()throws Exception;
	public DellproductDto emailusedgetProduct(String customerEmail)throws Exception;
	public DellproductDto mobileusedgetProduct(Long customerContact)throws Exception;

}
