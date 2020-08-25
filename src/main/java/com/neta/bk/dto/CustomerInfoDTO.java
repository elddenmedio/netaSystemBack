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

@XmlRootElement(namespace = "DTO", name = "CustomerInfoDTO")
@XmlAccessorType(XmlAccessType.FIELD)

public class CustomerInfoDTO extends BaseDTO {
	@XmlElement
    private Timestamp birthday;
	
	@XmlElement
    private String avatar;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerInfoDTO [birthday=");
		builder.append(birthday);
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append("]");
		return builder.toString();
	}
}
