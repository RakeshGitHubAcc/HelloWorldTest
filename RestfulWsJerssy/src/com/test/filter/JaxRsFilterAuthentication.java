package com.test.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.test.service.AuthenticationService;
//@Provider
public class JaxRsFilterAuthentication implements ContainerRequestFilter{
	public static final String AUTHENTICATION_HEADER = "Authorization";
	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) {
		String authCredentials = containerRequest.getHeaderValue(AUTHENTICATION_HEADER);
		AuthenticationService authenticationService = new AuthenticationService();		
		boolean authenticationStatus = authenticationService
				.authenticate(authCredentials);
		if (!authenticationStatus) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
		return null;
	}

}
