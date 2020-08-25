/**
 * 
 */
package com.neta.bk.ejb.local;

import javax.ejb.Local;

import com.neta.bk.entity.LoginEntity;
import com.neta.bk.model.LoginModel;

/**
 * @author elddenmedio
 *
 */

@Local
public interface LoginLocal {
	public LoginEntity validateLogin(LoginModel login) throws Exception;
}
