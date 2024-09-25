package com.example.dev.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.entity.Country;
import com.example.dev.repo.CountryRepository;
import com.example.dev.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	
	//no need to use auto wire annotation since spring bean has only one constructor
	@Autowired
private CountryRepository countryRepository;
	
	public CountryServiceImpl(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country getCountryById(Long id) {
		return countryRepository.findById(id).get();
	}

	@Override
	public Country updateCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public void deleteCountryById(Long id) {
		countryRepository.deleteById(id);	
	}


}
