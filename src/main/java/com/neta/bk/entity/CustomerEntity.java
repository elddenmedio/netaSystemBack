/**
 * 
 */
package com.neta.bk.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author elddenmedio
 *
 */

@Entity
@Table(name = "customer"/*, catalog = "Neta", schema = "public"*/)
@Cacheable(false)
@NamedQueries({
		@NamedQuery(name = CustomerEntity.findAll, query = "SELECT DISTINCT c FROM CustomerEntity c"),
		@NamedQuery(name = CustomerEntity.findByMail, query = "SELECT DISTINCT c FROM CustomerEntity c JOIN FETCH c.customer_info ci WHERE ci.mail=:mail"),
		})

public class CustomerEntity implements BaseEntity {
	private static final long serialVersionUID = 1L;
	public static final String findAll = "CustomerEntity.findAll";
	public static final String findByMail = "CustomerEntity.findByMail";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@Column(name = "surname")
	@NotNull
	private String surname;
	
	@Column(name = "secondsurname")
	@Nullable
	private String secondsurname;
	
	@Column(name = "active")
	@Nullable
	private Boolean active;
	
	@Column(name = "deleted")
	@Nullable
	private Boolean deleted;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY,  orphanRemoval = true)
    private List<TokenEntity> tokens = new ArrayList<>();
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private CustomerInfoEntity customer_info;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private LoginEntity login;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the secondsurname
	 */
	public String getSecondsurname() {
		return secondsurname;
	}

	/**
	 * @param secondsurname the secondsurname to set
	 */
	public void setSecondsurname(String secondsurname) {
		this.secondsurname = secondsurname;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the tokens
	 */
	public List<TokenEntity> getTokens() {
		return tokens;
	}

	/**
	 * @param tokens the tokens to set
	 */
	public void setTokens(List<TokenEntity> tokens) {
		this.tokens = tokens;
	}

	/**
	 * @return the customer_info
	 */
	public CustomerInfoEntity getCustomer_info() {
		return customer_info;
	}

	/**
	 * @param customer_info the customer_info to set
	 */
	public void setCustomer_info(CustomerInfoEntity customer_info) {
		if (customer_info == null) {
            if (this.customer_info != null) {
                this.customer_info.setCustomer(null);
            }
        }
        else {
        	customer_info.setCustomer(this);
        }

		this.customer_info = customer_info;
	}

	/**
	 * @return the login
	 */
	public LoginEntity getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(LoginEntity login) {
		if (login == null) {
            if (this.login != null) {
                this.login.setCustomer(null);
            }
        }
        else {
        	login.setCustomer(this);
        }

		this.login = login;
	}
}
