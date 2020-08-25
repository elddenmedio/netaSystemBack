/**
 * 
 */
package com.neta.bk.web.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.neta.bk.filters.CORSResponseFilter;
import com.neta.bk.ws.AccountWS;

/**
 * @author elddenmedio
 *
 */

@ApplicationPath("/services/")
public class Configurations extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(AccountWS.class);
		classes.add(CORSResponseFilter.class);

		//classes.add(org.glassfish.jersey.jackson.JacksonFeature.class);
		//classes.add(MyJacksonJsonProvider.class);

		return classes;
	}
}
