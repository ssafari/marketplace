package com.marketplace.customer.domains;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
	@NotNull
    @Size(max = 100)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
    @Size(max = 100)
	@Column(name="last_name")
	private String lastName;
	
	
	@NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
	private String email;
	
	@NotNull
    @Size(max = 100)
	@Column
	private String password;
	
	@Column
	private String token;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "addresses", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Address> addresses = new HashSet<>();
	
	public UserEntity() {}
	
	public UserEntity(String firstName, String lastName, 
			          String email, String password, Set<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}
/*	public void setId(Long id) {
		this.id = id;
	}
*/	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
