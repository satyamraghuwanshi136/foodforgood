package com.satyam.foodforgood.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@NotNull(message = "Email can not be null")
	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@NotNull(message = "Password can not be null")
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull(message = "Role can not be null")
	@Column(name = "role", nullable = false)
	private String role;
	
	@NotNull(message = "Name can not be null")
	@Column(name = "name",unique = true, nullable = false)
	private String name;
	
	@NotNull(message = "website_link can not be null")
	@Column(name = "website_link",unique = true, nullable = false)
	private String website_link;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "organisation")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Column(name = "offices")
	private List<OrganisationOffice> offices;

	public OrganisationInformation() {
		
	}

	public OrganisationInformation(@NotNull @Email String email, @NotNull @Min(4) String password,
			@NotNull @Min(5) String name, @NotNull String website_link,
			List<OrganisationOffice> offices) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.website_link = website_link;
		this.offices = offices;
	}

	public OrganisationInformation(@NotNull @Email String email, @NotNull @Min(4) String password,
			@NotNull String role,
			@NotNull @Min(5) String name, @NotNull String website_link,
			List<OrganisationOffice> offices) {
		this.email = email;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
