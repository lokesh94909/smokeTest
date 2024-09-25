package com.example.dev.controller;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.dev.entity.Country;
import com.example.dev.service.CountryService;

import java.util.List;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	 @Autowired
	    private RestTemplate restTemplate;

	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
	
	// handler method to handle list countries and return mode and view
	 @GetMapping("/countries/status")
	    public String listCountries(Model model) {
	        List<Country> countries = countryService.getAllCountries();
	        for (Country country : countries) {
	            String url = country.getUrl();
	            String status = checkUrlStatus(url) ? "Working" : "Not Working";
	            String loadTime = calculateLoadTime(url);
	            country.setStatus(status);
	            country.setLoadTime(loadTime);
	            countryService.updateCountry(country);
	        }
	        model.addAttribute("countries", countries);
	        return "status";
	    }

	    private boolean checkUrlStatus(String url) {
	        try {
	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	            connection.setRequestMethod("HEAD");
	            int responseCode = connection.getResponseCode();
	            return (responseCode == HttpURLConnection.HTTP_OK);
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    private String calculateLoadTime(String url) {
	        try {
	            long startTime = System.currentTimeMillis();
	            restTemplate.getForObject(url, String.class);
	            long endTime = System.currentTimeMillis();
	            long loadTime = endTime - startTime;
	            return loadTime + " ms";
	        } catch (Exception e) {
	            return "N/A";
	        }
	    }
	    
	    @GetMapping("/countries")
		public String listCountrys(Model model) {
			model.addAttribute("countries", countryService.getAllCountries());
			return "countries";
		}
		
		@GetMapping("/countries/new")
		public String createCountryForm(Model model) {
		    // create country object to hold country form data
		    Country country = new Country();
		    model.addAttribute("country", country);
		    return "create_country";
		}
		
		@PostMapping("/countries")
		public String saveCountry(@ModelAttribute("country") Country country) {
			countryService.saveCountry(country);
			return "redirect:/countries";
		}
		
		@GetMapping("/countries/edit/{id}")
		public String editCountryForm(@PathVariable Long id, Model model) {
			model.addAttribute("country", countryService.getCountryById(id));
			return "edit_country";
		}

		@PostMapping("/countries/{id}")
		public String updateCountry(@PathVariable Long id,
				@ModelAttribute("country") Country country,
				Model model) {
			
			// get country from database by id
			Country existingCountry = countryService.getCountryById(id);
			existingCountry.setId(id);
			existingCountry.setCountryName(country.getCountryName());
			existingCountry.setDetailDescription(country.getDetailDescription());
			existingCountry.setUrl(country.getUrl());
			
			
			// save updated country object
			countryService.updateCountry(existingCountry);
			return "redirect:/countries";		
		}
		
		// handler method to handle delete country request
		
		@GetMapping("/countries/{id}")
		public String deleteCountry(@PathVariable Long id) {
			countryService.deleteCountryById(id);
			return "redirect:/countries";
		}
		
	

}
