package com.test.service;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.tomcat.util.codec.binary.Base64;

public class AuthenticationService {
	public boolean authenticate(String authCredentials) {
		boolean authenticationStatus=false;
		if (null == authCredentials){
			authenticationStatus = false;
		}else{
			// header value format will be "Basic encodedstring" for Basic
			// authentication. Example "Basic YWRtaW46YWRtaW4="
			final String encodedUserPassword = authCredentials.replaceFirst("Basic"
					+ " ", "");
			String usernameAndPassword = null;
			try {
				byte[] decodedBytes = Base64.decodeBase64(encodedUserPassword);
				usernameAndPassword = new String(decodedBytes, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			final StringTokenizer tokenizer = new StringTokenizer(
					usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			// we have fixed the userid and password as admin
			// call some UserService/LDAP here
			 authenticationStatus = "admin".equals(username)
					&& "admin".equals(password);
		}
		return authenticationStatus;	
		
	}
}
