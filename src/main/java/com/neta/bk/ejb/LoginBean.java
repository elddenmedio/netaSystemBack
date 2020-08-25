/**
 * 
 */
package com.neta.bk.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neta.bk.ejb.local.LoginLocal;
import com.neta.bk.entity.CustomerEntity;
import com.neta.bk.entity.LoginEntity;
import com.neta.bk.model.LoginModel;

/**
 * @author elddenmedio
 *
 */

@Stateless(name="LoginLocal")
public class LoginBean implements LoginLocal {
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerBean.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public LoginEntity validateLogin(LoginModel login) throws Exception {
		try {
			Query query = entityManager.createNamedQuery(LoginEntity.findLogin)
															.setParameter("username", login.getUsername().toString())
															.setParameter("password", login.getPassword().toString());
			
			return (LoginEntity) query.getSingleResult();
		} catch(NoResultException e) {
	        throw new Exception("ALERTS.error.login");
	    }
	}
}
