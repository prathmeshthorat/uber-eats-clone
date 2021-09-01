package com.ueats.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ueats.orderservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	@Query(value = "SELECT * FROM ADDRESS A WHERE A.USER_ID=?1", nativeQuery = true)
	List<Address> findByUser(long userId);

}
