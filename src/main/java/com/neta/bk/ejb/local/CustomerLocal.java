/**
 * 
 */
package com.neta.bk.ejb.local;

import javax.ejb.Local;

import org.json.JSONObject;

import com.neta.bk.entity.CustomerEntity;
import com.neta.bk.entity.LoginEntity;
import com.neta.bk.entity.TokenEntity;
import com.neta.bk.model.LoginModel;
import com.neta.bk.model.RegisterModel;

/**
 * @author elddenmedio
 *
 */

@Local
public interface CustomerLocal {
	public JSONObject findAllCustomer();
	public JSONObject findCustomerByMail(String mail);
	public CustomerEntity findCustomerByID(Long customerID);
	public CustomerEntity activateCustomer(Long customerID);
	public CustomerEntity createCustomer(RegisterModel register) throws Exception;
	public JSONObject validatedLogin(LoginModel login) throws Exception;
	public JSONObject getCustomerLoginInfo(LoginEntity entity);
	public JSONObject getCustomerRegisterInfo(TokenEntity entity, String token) throws Exception;
}
