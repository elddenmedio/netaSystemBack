/**
 * 
 */
package com.neta.bk.model;

/**
 * @author elddenmedio
 *
 */

public class RegisterModel {
	private String name;
	private String surname;
	private String secondsurname;
	private String mail;
	private String password;
	
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
	 * @param surename the surname to set
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterModel [name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", secondsurname=");
		builder.append(secondsurname);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
}
