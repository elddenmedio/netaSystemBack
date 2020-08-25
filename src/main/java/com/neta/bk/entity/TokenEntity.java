/**
 * 
 */
package com.neta.bk.entity;

import java.sql.Timestamp;

import javax.annotation.Nullable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "token"/*, catalog = "Neta", schema = "public"*/)
@Cacheable(false)
@NamedQueries({
		@NamedQuery(name = TokenEntity.findAll, query = "SELECT DISTINCT t FROM TokenEntity t"),
		@NamedQuery(name = TokenEntity.findAllByCustomer, query = "SELECT DISTINCT t FROM TokenEntity t JOIN FETCH t.customer c WHERE c.id=:customer"),
		@NamedQuery(name = TokenEntity.findByToken, query = "SELECT DISTINCT t FROM TokenEntity t JOIN FETCH t.customer c WHERE t.token=:token")
		})

public class TokenEntity implements BaseEntity {
	private static final long serialVersionUID = 1L;
	public static final String findAll = "TokenEntity.findAll";
	public static final String findAllByCustomer = "TokenEntity.findAllByCustomer";
	public static final String findByToken = "TokenEntity.findByToken";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "customer_id")
	@NotNull
	private Long customer_id;
	
	@Column(name = "token")
	@NotNull
	private String token;
	
	@Column(name = "date_created")
	@Nullable
	private Timestamp date_created;
	
	@Column(name = "date_renewal")
	@Nullable
	private Timestamp date_renewal;
	
	@Column(name = "date_down")
	@Nullable
	private Timestamp date_down;
	
	@Column(name = "active")
	@Nullable
	private Boolean active;
	
	@Column(name = "deleted")
	@Nullable
	private Boolean deleted;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", updatable=false, insertable = false)
    private CustomerEntity customer;

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
	 * @return the customer_id
	 */
	public Long getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the date_created
	 */
	public Timestamp getDate_created() {
		return date_created;
	}

	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}

	/**
	 * @return the date_renewal
	 */
	public Timestamp getDate_renewal() {
		return date_renewal;
	}

	/**
	 * @param date_renewal the date_renewal to set
	 */
	public void setDate_renewal(Timestamp date_renewal) {
		this.date_renewal = date_renewal;
	}

	/**
	 * @return the date_down
	 */
	public Timestamp getDate_down() {
		return date_down;
	}

	/**
	 * @param date_down the date_down to set
	 */
	public void setDate_down(Timestamp date_down) {
		this.date_down = date_down;
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
