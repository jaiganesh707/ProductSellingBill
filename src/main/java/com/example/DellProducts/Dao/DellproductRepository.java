package com.example.DellProducts.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DellProducts.Entity.DellProduct;

@Repository
public interface DellproductRepository extends CrudRepository<DellProduct, Integer>{
	
	Optional<DellProduct> findBycustomerEmail(String customerEmail);
	Optional<DellProduct> findBycustomerContact(Long customerContact);
	
}
