package com.example.DellProducts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DellProducts.Model.DellproductDto;
import com.example.DellProducts.Service.DellproductService;

@RestController
@RequestMapping("/dellproducts")
public class DellproductController {
	
	@Autowired
	private DellproductService dellproductService;

	@GetMapping("/getproducts")
	public ResponseEntity<DellproductDto> entity(@RequestParam ("billNumber")int billNumber)throws Exception{
		
		DellproductDto dellproductDto=dellproductService.getDellproducts(billNumber);
		ResponseEntity<DellproductDto> responseEntity=new ResponseEntity<>(dellproductDto, HttpStatus.OK);
		return responseEntity;		
	}
	
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<String> entity1(@RequestParam ("billNumber")int billNumber)throws Exception{
		
		dellproductService.deleteDellproduct(billNumber);
		String message="Sucessfully Deleted";
		ResponseEntity<String> responseEntity=new ResponseEntity<>(message, HttpStatus.OK);
		return responseEntity;
		
	}
	
	@PostMapping("/insertproduct")
	public ResponseEntity<String> entity3(@RequestBody DellproductDto dellproductDto)throws Exception{
		ResponseEntity<String> responseEntity=null;
		try {
			dellproductService.addDellproduct(dellproductDto);
			String insert="Successfully Inserted" + dellproductDto.getCustomerName() + "New User";
			responseEntity=new ResponseEntity<>(insert, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

		return responseEntity;
		
	}
	
	@PutMapping("/updateproduct")
	public ResponseEntity<String> entity4(@RequestBody DellproductDto dellproductDto)throws Exception{
		
		dellproductService.updateDellproduct(dellproductDto);
		String message="successfully Updated";
		ResponseEntity<String> responseEntity=new ResponseEntity<>(message, HttpStatus.OK);		
		return responseEntity;
		
	}
	
	@GetMapping("/getproductusingmail")
	public ResponseEntity<DellproductDto> entity(@RequestParam ("customerEmail")String customerEmail)throws Exception{
		DellproductDto dellproductDto= dellproductService.emailusedgetProduct(customerEmail);
		ResponseEntity<DellproductDto> responseEntity=new ResponseEntity<>(dellproductDto, HttpStatus.OK);
		return responseEntity;
	}
		
	@GetMapping("/getproductusingcontactno")
	ResponseEntity<DellproductDto> entity(@RequestParam ("customerContact")Long customerContact)throws Exception{
		DellproductDto dellproductDto=dellproductService.mobileusedgetProduct(customerContact);
		ResponseEntity<DellproductDto> responseEntity=new ResponseEntity<>(dellproductDto, HttpStatus.OK);
		return responseEntity;
	}
	
	
}
