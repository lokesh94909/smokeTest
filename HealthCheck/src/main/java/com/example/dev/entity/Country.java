package com.example.dev.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "country_name", nullable = false)
	private String countryName;
	
	@Column(name = "detail_description")
	private String detailDescription;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "status")
    private String status;

    @Column(name = "load_time")
    private String loadTime;
	
	public Country() {
		
	}
	
	public Country(String countryName, String detailDescription, String url,String status,String loadTime) {
		super();
		this.countryName = countryName;
		this.detailDescription = detailDescription;
		this.url = url;
		this.status = status;
		this.loadTime = loadTime;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(String loadTime) {
		this.loadTime = loadTime;
	}
	
	

	
	

}
