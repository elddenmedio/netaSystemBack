/**
 * 
 */
package com.neta.bk.entity;

import java.sql.Timestamp;

import javax.annotation.Nullable;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "customer_info"/*, catalog = "Neta", schema = "public"*/)
@Cacheable(false)
@NamedQueries({
		@NamedQuery(name = CustomerInfoEntity.findAll, query = "SELECT DISTINCT ci FROM CustomerInfoEntity ci"),
		})

public class CustomerInfoEntity implements BaseEntity {
	private static final long serialVersionUID = 1L;
	public static final String findAll = "CustomerInfoEntity.findAll";
	
	@Id
    private Long id;
	
	@Column(name = "mail")
	@NotNull
	private String mail;
	
	@Column(name = "birthday")
	@Nullable
	private Timestamp birthday;
	
	@Column(name = "avatar")
	@NotNull
	private String avatar;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private CustomerEntity customer;
	
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the birthday
	 */
	public Timestamp getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

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
}
