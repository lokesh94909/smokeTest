package com.example.dev.service;


import java.util.List;

import com.example.dev.entity.Country;

public interface CountryService {
	
List<Country> getAllCountries();
	
	Country saveCountry(Country country);
	
	
	Country getCountryById(Long id);
	
	Country updateCountry(Country country);
	
	void deleteCountryById(Long id);



}
