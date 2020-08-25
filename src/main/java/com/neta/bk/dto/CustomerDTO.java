/**
 * 
 */
package com.neta.bk.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author elddenmedio
 *
 */

@XmlRootElement(namespace = "DTO", name = "CustomerDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class CustomerDTO extends BaseDTO {
	@XmlElement
    private Long id;
	
	@XmlElement
    private String name;
	
	@XmlElement
    private String surname;
	
	@XmlElement
    private String secondsurname;
	
	@XmlElement
    private String mail;
	
	@XmlElement
    private CustomerInfoDTO customer_info;
	
	@XmlElement
    private Boolean active;
	
	@XmlElement
    private Boolean deleted;

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
	 * @return the customer_info
	 */
	public CustomerInfoDTO getCustomer_info() {
		return customer_info;
	}

	/**
	 * @param customer_info the customer_info to set
	 */
	public void setCustomer_info(CustomerInfoDTO customer_info) {
		this.customer_info = customer_info;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", secondsurname=");
		builder.append(secondsurname);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", customer_info=");
		builder.append(customer_info);
		builder.append(", active=");
		builder.append(active);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}
}
