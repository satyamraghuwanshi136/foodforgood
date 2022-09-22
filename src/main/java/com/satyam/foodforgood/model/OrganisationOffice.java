package com.satyam.foodforgood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "organisation_office")
public class OrganisationOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organisation_office_id")
	private int organisation_office_id;
	
	@NotNull
	@NotEmpty
	@Column(name = "city", nullable = false)
	private String city;

	@NotNull
	@NotEmpty
	@Column(name = "state", nullable = false)
	private String state;
	
	@NotNull
	@NotEmpty
	@Column(name = "address", nullable = false)
	private String address;
	
	@NotNull
	@NotEmpty
	@Column(name = "poc_name", nullable = false)
	private String poc_name;
	
	@NotNull
	@NotEmpty
	@Column(name = "poc_email", nullable = false)
	private String poc_email;
	
	@NotEmpty
	@NotNull
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "organisation_information_id", referencedColumnName = "organisation_information_id" , nullable = false)
	private OrganisationInformation organisation;

	public OrganisationOffice() {
	}

	public OrganisationOffice(@NotNull @NotEmpty String city, @NotNull @NotEmpty String state,
			@NotNull @NotEmpty String address, @NotNull @NotEmpty String poc_name, @NotNull @NotEmpty String poc_email,
			@NotEmpty @NotNull OrganisationInformation organisation) {
		this.city = city;
		this.state = state;
		this.address = address;
		this.poc_name = poc_name;
		this.poc_email = poc_email;
		this.organisation = organisation;
	}

	public int getOrganisation_office_id() {
		return organisation_office_id;
	}

	public void setOrganisation_office_id(int organisation_office_id) {
		this.organisation_office_id = organisation_office_id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPoc_name() {
		return poc_name;
	}

	public void setPoc_name(String poc_name) {
		this.poc_name = poc_name;
	}

	public String getPoc_email() {
		return poc_email;
	}

	public void setPoc_email(String poc_email) {
		this.poc_email = poc_email;
	}

	public OrganisationInformation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationInformation organisation) {
		this.organisation = organisation;
	}
	
	
	
}
