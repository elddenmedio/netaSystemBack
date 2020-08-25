/**
 * 
 */
package com.neta.bk.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neta.bk.dto.TokenDTO;
import com.neta.bk.ejb.local.CustomerLocal;
import com.neta.bk.entity.CustomerEntity;
import com.neta.bk.entity.TokenEntity;
import com.neta.bk.model.LoginModel;
import com.neta.bk.model.RegisterModel;

/**
 * @author elddenmedio
 *
 */

@Path("v1/account")
public class AccountWS {
	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB(name = "CustomerLocal")
	private CustomerLocal customerLocal;
	
	private static Logger LOGGER = LoggerFactory.getLogger(AccountWS.class);
	
	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@Context HttpServletRequest request,
										@QueryParam("mail") String mail) {
		try {
			if(mail == null) {
				JSONObject result = (JSONObject) customerLocal.findAllCustomer();
				
				return Response.ok(result.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
			} else {
				JSONObject result = (JSONObject) customerLocal.findCustomerByMail(mail);
				
				return Response.ok(result.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//return Response.status(204).build();
			return Response.noContent().build();
		}
	}
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postRegister(@Context HttpServletRequest request, RegisterModel registerModel) {
		try {
			CustomerEntity customer = (CustomerEntity) customerLocal.createCustomer(registerModel);
			
			JSONObject result = new JSONObject();
			result.put("customerID", customer.getId());
			
			return Response.ok(result.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postLogin(@Context HttpServletRequest request, LoginModel loginModel) {
		try {
			String[] username = loginModel.getUsername().split("@");
			LoginModel login = new LoginModel();
			login.setUsername(username[0]);
			login.setPassword(loginModel.getPassword());
			JSONObject result = customerLocal.validatedLogin(login);
			//String token = request.getHeader("Authorization").replace("\"", "").trim();
			
			return Response.ok(result.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			
			return Response.status(Response.Status.EXPECTATION_FAILED).entity("ALERTS.error.login").build();
		}
	}
	
	@POST
	@Path("resetPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resetPassword(@Context HttpServletRequest request, LoginModel reset) {
		try {
			return Response.ok().build();
		} catch (Exception ex) {
			ex.printStackTrace();
			
			return Response.serverError().build();
		}
	}
}
