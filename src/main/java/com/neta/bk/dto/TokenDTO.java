/**
 * 
 */
package com.neta.bk.dto;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author elddenmedio
 *
 */

@XmlRootElement(namespace = "DTO", name = "TokenDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class TokenDTO extends BaseDTO {
	@XmlElement
    private Long id;
	
	@XmlElement
    private String token;
	
	@XmlElement
    private Timestamp date_created;
	
	@XmlElement
    private Timestamp date_renewal;
	
	@XmlElement
    private Timestamp date_down;
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenDTO [id=");
		builder.append(id);
		builder.append(", token=");
		builder.append(token);
		builder.append(", date_created=");
		builder.append(date_created);
		builder.append(", date_renewal=");
		builder.append(date_renewal);
		builder.append(", date_down=");
		builder.append(date_down);
		builder.append(", active=");
		builder.append(active);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}
}
