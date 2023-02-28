package com.williambertoldo.cadastro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_ADDRESS")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public long clientId;
    public String zipCode;
    public String street;
    public long houseNo;
    public String city;
    public Boolean mainAddress;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public long getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(long houseNo) {
		this.houseNo = houseNo;
	}
    public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}    
    public Boolean getMainAddress() {
		return mainAddress;
	}
	public void setMainAddress(Boolean mainAddress) {
		this.mainAddress = mainAddress;
	}
    
    
}
