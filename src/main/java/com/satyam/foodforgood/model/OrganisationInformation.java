package com.satyam.foodforgood.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "organisation_information")
public class OrganisationInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organisation_information_id")
	private int organisation_information_id;
	
	@NotNull
	@NotEmpty
	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@NotNull
	@NotEmpty
	@Min(4)
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull
	@NotEmpty
	@Min(5)
	@Column(name = "name",unique = true, nullable = false)
	private String name;
	
	@NotNull
	@NotEmpty
	@Column(name = "website_link",unique = true, nullable = false)
	private String website_link;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "organisation")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Column(name = "offices")
	private List<OrganisationOffice> offices;

	public OrganisationInformation() {
		
	}

	public OrganisationInformation(@NotNull @NotEmpty @Email String email, @NotNull @NotEmpty @Min(4) String password,
			@NotNull @NotEmpty @Min(5) String name, @NotNull @NotEmpty String website_link,
			List<OrganisationOffice> offices) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.website_link = website_link;
		this.offices = offices;
	}

	public int getOrganisation_information_id() {
		return organisation_information_id;
	}

	public void setOrganisation_information_id(int organisation_information_id) {
		this.organisation_information_id = organisation_information_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite_link() {
		return website_link;
	}

	public void setWebsite_link(String website_link) {
		this.website_link = website_link;
	}

	public List<OrganisationOffice> getOffices() {
		return offices;
	}

	public void setOffices(List<OrganisationOffice> offices) {
		this.offices = offices;
	} 
	
	
	
	
}
