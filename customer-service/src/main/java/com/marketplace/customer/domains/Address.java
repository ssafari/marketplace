package com.marketplace.customer.domains;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Address type which will be embedded inside the User Entity table.
 * 
 * @author Sepehr Safari
 *
 */
@Embeddable
public class Address {
	@NotNull
    @Size(max = 100)
    private String street;

    @Size(max = 100)
    private String unit;

    @NotNull
    @Size(max = 100)
    private String city;

    @NotNull
    @Size(max = 100)
    private String state;

    @NotNull
    @Size(max = 100)
    private String country;

    @NotNull
    @Size(max = 100)
    private String zipCode;

    public Address() {

    }

    public Address(String street, String unit, String city, 
                   String state, String country, String zipCode) {
        this.street = street;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUnit() {
		return unit;
	}

	public void setAUnit(String unit) {
		this.unit = unit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
