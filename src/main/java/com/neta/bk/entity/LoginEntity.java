/**
 * 
 */
package com.neta.bk.entity;

import javax.annotation.Nullable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author elddenmedio
 *
 */

@Entity
@Table(name = "login"/*, catalog = "Neta", schema = "public"*/)
@Cacheable(false)
@NamedQueries({
		@NamedQuery(name = LoginEntity.findAll, query = "SELECT DISTINCT l FROM LoginEntity l"),
		@NamedQuery(name = LoginEntity.findLogin, query = "SELECT DISTINCT l FROM LoginEntity l JOIN FETCH l.customer c WHERE l.username=:username AND l.password=:password AND c.active=true"),
		})

public class LoginEntity implements BaseEntity {
	private static final long serialVersionUID = 1L;
	public static final String findAll = "LoginEntity.findAll";
	public static final String findLogin = "LoginEntity.findLogin";
	
	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private CustomerEntity customer;
	
	@Column(name = "username")
	@NotNull
	private String username;
	
	@Column(name = "password")
	@NotNull
	private String password;

	/**
	 * @return the customer
	 */
	public CustomerEntity getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
