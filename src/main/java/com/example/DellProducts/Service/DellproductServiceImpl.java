package com.example.DellProducts.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DellProducts.Dao.DellproductRepository;
import com.example.DellProducts.Entity.DellProduct;
import com.example.DellProducts.Model.DellproductDto;
@Service
public class DellproductServiceImpl implements DellproductService{
	@Autowired
	private DellproductRepository dellproductRepository;
	
	@Override
	public void addDellproduct(DellproductDto dellproductDto) throws Exception {
		// TODO Auto-generated method stub
	
		DellProduct dellProduct=DellproductDto.createEntity(dellproductDto);
		dellproductRepository.save(dellProduct);
		
	}

	@Override
	public DellproductDto getDellproducts(int billNumber) throws Exception {
		// TODO Auto-generated method stub
		Optional<DellProduct> entityStoreOptional=dellproductRepository.findById(billNumber);
		DellProduct dellProduct=entityStoreOptional.get();
		DellproductDto dellproductDto=DellProduct.getproductModel(dellProduct);
		
		return dellproductDto;
	}

	@Override
	public void updateDellproduct(DellproductDto dellproductDto) throws Exception {
		// TODO Auto-generated method stub
		Optional<DellProduct> optional=dellproductRepository.findById(dellproductDto.getBillNumber());
		DellProduct dellProduct=optional.get();
		dellProduct.setBillNumber(dellProduct.getBillNumber());
		dellProduct.setProductName(dellproductDto.getProductName());
		dellProduct.setProductBrand(dellproductDto.getProductBrand());
		dellProduct.setProductSeries(dellproductDto.getProductSeries());
		dellProduct.setProductPrice(dellproductDto.getProductPrice());
		dellProduct.setCustomerName(dellproductDto.getCustomerName());
		dellProduct.setCustomerEmail(dellproductDto.getCustomerEmail());
		dellProduct.setCustomerContact(dellproductDto.getCustomerContact());
		dellproductRepository.save(dellProduct);
	}

	@Override
	public void deleteDellproduct(int billNumber) throws Exception {
		// TODO Auto-generated method stub
		Optional<DellProduct> optional=dellproductRepository.findById(billNumber);
		DellProduct dellProduct=optional.get();
		dellproductRepository.delete(dellProduct);
		
	}

	@Override
	public List<DellproductDto> getallDellproducts() throws Exception {
		// TODO Auto-generated method stub
		List<DellproductDto> list=new ArrayList<>();
		Iterable<DellProduct> iterable=dellproductRepository.findAll();
		for(DellProduct dellProduct:iterable) {
				list.add(DellProduct.getproductModel(dellProduct));
		}
		return list;
	}

	@Override
	public DellproductDto emailusedgetProduct(String customerEmail) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<DellProduct> optional=dellproductRepository.findBycustomerEmail(customerEmail);
		DellProduct dellProduct=optional.get();
		DellproductDto dellproductDto=DellProduct.getproductModel(dellProduct);
		return dellproductDto;
		
		
	}

	@Override
	public DellproductDto mobileusedgetProduct(Long customerContact) throws Exception {
		// TODO Auto-generated method stub
		Optional<DellProduct> optional=dellproductRepository.findBycustomerContact(customerContact);
		DellProduct dellProduct=optional.get();
		DellproductDto dellproductDto=DellProduct.getproductModel(dellProduct);
		return dellproductDto;
		
	}

}
