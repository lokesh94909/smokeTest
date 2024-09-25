package com.example.dev.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.dev.entity.Country;


public interface CountryRepository  extends JpaRepository<Country, Long>{
	

	@Transactional
    @Modifying
    @Query("UPDATE Country c SET c.status = ?2, c.loadTime = ?3 WHERE c.id = ?1")
    void updateStatusAndLoadTime(Long id, String status, String loadTime);
	
	
}
